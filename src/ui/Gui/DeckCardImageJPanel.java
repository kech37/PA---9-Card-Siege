/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.Gui;

import Logic.ObservableGame;
import Logic.States.AwaitTopCardToBeDrawn;
import java.awt.Dimension;
import java.awt.Graphics;
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
 * @author a21220528
 */
public class DeckCardImageJPanel extends JPanel implements Observer {

    private Image image = null;
    private final ObservableGame observableGame;
    
    public DeckCardImageJPanel(ObservableGame observableGame) {
        this.observableGame = observableGame;
        this.observableGame.addObserver(this);
        
        setupComponents();
        setupLayout();
    }

    @Override
    public void paintComponent(Graphics g) {
        g.drawImage(image, 1, 1, image.getWidth(this), image.getHeight(this), this);
    }

    @Override
    public void update(Observable o, Object o1) {
        if (observableGame.getState() instanceof AwaitTopCardToBeDrawn) { 
            if (observableGame.getNCards() == 1) {
                try {
                    image = javax.imageio.ImageIO.read(new java.net.URL(getClass().getResource("Images/BackCard.png"), "BackCard.png"));
                } catch (MalformedURLException ex) {
                    Logger.getLogger(InicialMenuJPanel.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(InicialMenuJPanel.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    private void setupComponents() {
        try {
            image = javax.imageio.ImageIO.read(new java.net.URL(getClass().getResource("Images/CardDeck.png"), "CardDeck.png"));
        } catch (MalformedURLException ex) {
            Logger.getLogger(InicialMenuJPanel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(InicialMenuJPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void setupLayout() {
        setMinimumSize(new Dimension(image.getWidth(this), image.getHeight(this)));
        setMaximumSize(new Dimension(image.getWidth(this), image.getHeight(this)));
        setPreferredSize(new Dimension(image.getWidth(this), image.getHeight(this)));
        setOpaque(false);
    }

}
