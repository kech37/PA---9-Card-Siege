/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.Gui;

import Logic.ObservableGame;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import static ui.Gui.Constants.*;


public class MainGameJFrame extends JFrame implements Observer {

    private ObservableGame observableGame;

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
            try {
                observableGame.loadGame();
            } catch (IOException | ClassNotFoundException ex) {
                Logger.getLogger(MainGameJFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        menu.add(menuItem);

        menuItem = new JMenuItem("Save");
        menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
        menuItem.addActionListener((ActionEvent ev) -> {
            observableGame.saveGame();
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
