/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.Gui;

import Logic.ObservableGame;
import java.awt.BorderLayout;
import java.awt.ComponentOrientation;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Observable;
import java.util.Observer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;

/**
 *
 * @author andre
 */
public class HomePagePanel extends JPanel implements Observer {

    private ObservableGame observableGame;
    private AwaitTopCardToBeDrawnPanel awaitTopCardToBeDrawn;
    private JPanel bottomPanel;

    public HomePagePanel(ObservableGame observableGame) {
        this.observableGame = observableGame;
        this.observableGame.addObserver(this);

        setupComponents();
        setupLayout();
    }

    private void setupComponents() {
        awaitTopCardToBeDrawn = new AwaitTopCardToBeDrawnPanel(observableGame);
        bottomPanel = new JPanel();
    }

    private void setupLayout() {

        bottomPanel.setOpaque(false);
        
        bottomPanel.setLayout(new GridLayout(1, 3));
        bottomPanel.add(new EnemyPanel(observableGame),BorderLayout.CENTER);
        bottomPanel.add(new AwaitActionSelectionPanel(observableGame));
        bottomPanel.add(new StatusPanel(observableGame),BorderLayout.CENTER);
        
        add(awaitTopCardToBeDrawn, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.CENTER);

        setLayout(new GridLayout(2, 1));
    }

    @Override
    public void paintComponent(Graphics g) {

        Image image = null;
        try {
            image = javax.imageio.ImageIO.read(new java.net.URL(getClass().getResource("Images/Red_Background.png"), "Red_Background.png"));
        } catch (MalformedURLException ex) {
            Logger.getLogger(FirstMenuPanel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FirstMenuPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        //     g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), this);
    }

    @Override
    public void update(Observable o, Object o1) {

    }

}
