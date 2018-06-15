/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.Gui;

import Logic.FileManager;
import Logic.ObservableGame;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Observable;
import java.util.Observer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.filechooser.FileNameExtensionFilter;
import static ui.Gui.Constants.*;

/**
 *
 * @author andre
 */
public class MainGameJFrame extends JFrame implements Observer {

    private ObservableGame observableGame;
    //private HomePagePanel panel;

    public MainGameJFrame(ObservableGame j, int x, int y) {
        this(j, x, y, DIM_X_HOMEPAGE, DIM_Y_HOMEPAGE);
    }

    public MainGameJFrame(ObservableGame j, int x, int y, int width, int height) {
        super("9 Card Siege - The game");

        observableGame = j;

        observableGame.addObserver(this);

        Container cp = getContentPane();

        JMenuBar menuBar = new JMenuBar();

        JMenu menu = new JMenu("Menu");
        menu.setMnemonic(KeyEvent.VK_M);
        menu.getAccessibleContext().setAccessibleDescription("Game menu");
        menuBar.add(menu);

        JMenuItem menuItem;

        menuItem = new JMenuItem("Load");
        menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, ActionEvent.CTRL_MASK));
        menuItem.addActionListener((ActionEvent ev) -> {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setCurrentDirectory(new File(FileManager.folder));
            fileChooser.setAcceptAllFileFilterUsed(false);
            fileChooser.addChoosableFileFilter(new FileNameExtensionFilter(
                    "(.9cs) 9 Card Siege save file",
                    "9cs"
            ));

            if (fileChooser.showOpenDialog(MainGameJFrame.this) == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
                try {
                    observableGame.loadGameWithName(file.getName());
                    JOptionPane.showMessageDialog(
                            null,
                            "Game load with sucess!",
                            "Sucess!",
                            JOptionPane.INFORMATION_MESSAGE
                    );
                } catch (IOException | ClassNotFoundException ex) {
                    JOptionPane.showMessageDialog(
                            null,
                            "Check console log for more information.",
                            "Error!",
                            JOptionPane.ERROR_MESSAGE
                    );
                    Logger.getLogger(MainGameJFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        menu.add(menuItem);

        menuItem = new JMenuItem("Save");
        menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
        menuItem.addActionListener((ActionEvent ev) -> {
            String fileName;
            fileName = (String) JOptionPane.showInputDialog(
                    null,
                    "Input for savegame name",
                    "Save",
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    null,
                    new SimpleDateFormat("dd MM yyyy - HH mm").format(new Date())
            );
            if (fileName != null) {
                observableGame.saveGameWithName(fileName);
                JOptionPane.showMessageDialog(
                        null,
                        "File '" + fileName + FileManager.extension + "' save with sucess!",
                        "Sucess!",
                        JOptionPane.INFORMATION_MESSAGE
                );
            }
        });
        menu.add(menuItem);

        menu.addSeparator();

        menuItem = new JMenuItem("Exit");
        menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, ActionEvent.CTRL_MASK));
        menuItem.addActionListener((ActionEvent ev) -> {
            Object[] options = {"Sim", "Não"};
            int sel = JOptionPane.showOptionDialog(null, "Tem a certeza que quer sair?", "Exit", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
            if (sel == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
        });
        menu.add(menuItem);

        setJMenuBar(menuBar);

        cp.setLayout(new GridLayout(2, 2));
        cp.add(new EnemyJPanel(observableGame));
        cp.add(new StatusJPanel(observableGame));
        cp.add(new DeckNCardJPanel(observableGame));
        cp.add(new GameOptionsJPanel(observableGame));

        setSize(width, height);
        setLocationRelativeTo(null);

        setMinimumSize(new Dimension(width, height));
        setVisible(true);
        addWindowListener(new WindowsClosing());
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        observableGame.SetUpdate();

        validate();
    }

    @Override
    public void update(Observable o, Object o1) {

    }

    private class WindowsClosing extends WindowAdapter {

        @Override
        public void windowClosing(WindowEvent e) {
            Object[] options = {"Sim", "Não"};
            int sel = JOptionPane.showOptionDialog(MainGameJFrame.this, "Tem a certeza que quer sair?", "Exit", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
            if (sel == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
        }
    }

}
