/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.Gui;

import Logic.FileManager;
import Logic.ObservableGame;
import Logic.States.AwaitBegining;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Observable;
import java.util.Observer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author andre
 */
public class InicialMenuJPanel extends JPanel implements Observer {

    private ObservableGame observableGame;

    LogoImage logo;
    OptionsMenu options;
    Box boxcenter;

    public InicialMenuJPanel(ObservableGame j) {
        observableGame = j;
        observableGame.addObserver(this);
        setupComponents();
        setupLayout();
    }

    public void setupComponents() {
        logo = new LogoImage();
        options = new OptionsMenu(observableGame);
        boxcenter = Box.createVerticalBox();
    }

    public void setupLayout() {

        logo.setLayout(new BorderLayout());
        //options.setLayout(new BorderLayout());

        add(logo, BorderLayout.WEST);
        add(options, BorderLayout.CENTER);

        setLayout(new GridLayout(2, 1));

    }

    @Override
    public void paintComponent(Graphics g) {

        Image image = null;
        try {
            image = javax.imageio.ImageIO.read(new java.net.URL(getClass().getResource("Images/Fundo.png"), "Fundo.png"));
        } catch (MalformedURLException ex) {
            Logger.getLogger(InicialMenuJPanel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(InicialMenuJPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), this);
    }

    @Override
    public void update(Observable o, Object o1) {
        setVisible(observableGame.getState() instanceof AwaitBegining);
    }
}

class LogoImage extends JPanel {

    public LogoImage() {
        setOpaque(true);
        setupComponents();
        setupLayout();
    }

    public void setupComponents() {
    }

    public void setupLayout() {
        setMinimumSize(new Dimension(100, 100));
        setPreferredSize(new Dimension(100, 100));
        setMaximumSize(new Dimension(100, 100));
    }

    @Override
    public void paintComponent(Graphics g) {
        Image image = null;
        try {
            image = javax.imageio.ImageIO.read(new java.net.URL(getClass().getResource("Images/LogoR.png"), "LogoR.png"));
        } catch (MalformedURLException ex) {
            Logger.getLogger(InicialMenuJPanel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(InicialMenuJPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        g.drawImage(image, 50, 50, this.getWidth() - 100, this.getHeight() - 100, this);
    }
}

class OptionsMenu extends JPanel implements Observer {

    private JButton jb1;
    private JButton jb2;
    private JButton jb3;
    private ObservableGame observableGame;

    public OptionsMenu(ObservableGame j) {
        observableGame = j;
        observableGame.addObserver(this);
        this.setOpaque(false);
        setupComponents();
        setupLayout();
    }

    public void setupComponents() {
        jb1 = new JButton("New Game");
        jb2 = new JButton("Continue");
        jb3 = new JButton("  Exit  ");

        jb1.setForeground(Color.white);
        jb2.setForeground(Color.white);
        jb3.setForeground(Color.white);

        jb1.setBackground(Color.BLACK);
        jb2.setBackground(Color.BLACK);
        jb3.setBackground(Color.BLACK);

        JPanel mainbox = new JPanel();

        Box b1 = Box.createHorizontalBox();
        Box b2 = Box.createHorizontalBox();
        Box b3 = Box.createHorizontalBox();

        jb1.setMinimumSize(new Dimension(100, 25));
        jb1.setPreferredSize(new Dimension(100, 25));
        jb1.setMaximumSize(new Dimension(100, 25));

        jb2.setMinimumSize(new Dimension(100, 25));
        jb2.setPreferredSize(new Dimension(100, 25));
        jb2.setMaximumSize(new Dimension(100, 25));

        jb3.setMinimumSize(new Dimension(100, 25));
        jb3.setPreferredSize(new Dimension(100, 25));
        jb3.setMaximumSize(new Dimension(100, 25));

        FileManager fileManager = new FileManager();
        if (fileManager.checkSavegameFile()) {
            jb2.setEnabled(true);
        } else {
            jb2.setEnabled(false);
        }

        b1.add(jb1);
        b2.add(jb2);
        b3.add(jb3);

        jb1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ev) {
                observableGame.StartGame();

                MainGameJFrame home = new MainGameJFrame(observableGame, 1, 1);

            }
        });

        jb3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ev) {
                System.exit(0);
            }
        });

        mainbox.add(b1, BorderLayout.CENTER);
        mainbox.add(b2, BorderLayout.CENTER);
        mainbox.add(b3);

        mainbox.setLayout(new GridLayout(3, 1, 20, 20));
        mainbox.setOpaque(false);
        add(mainbox);
    }

    public void setupLayout() {
        setMaximumSize(new Dimension(5, 5));
        setPreferredSize(new Dimension(5, 5));
        setMinimumSize(new Dimension(5, 5));
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
    }

    @Override
    public void update(Observable o, Object o1) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
