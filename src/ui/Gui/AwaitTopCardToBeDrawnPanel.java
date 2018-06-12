/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.Gui;

import Logic.ObservableGame;
import Logic.States.AwaitTopCardToBeDrawn;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.Panel;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Observable;
import java.util.Observer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Box;
import javax.swing.JPanel;

/**
 *
 * @author andre
 */
public class AwaitTopCardToBeDrawnPanel extends JPanel implements Observer, Constants {

    private ObservableGame observableGame;
    private DeckCardImage deckimage;
    private CardImage cardimage;
    private JPanel content;
    private Box boxes[];

    public AwaitTopCardToBeDrawnPanel(ObservableGame observableGame) {
        this.observableGame = observableGame;
        this.observableGame.addObserver(this);
        setupComponents();
        setupLayout();
    }

    private void setupComponents() {
        deckimage = new DeckCardImage(observableGame);
        cardimage = new CardImage(observableGame);
        content = new JPanel();
        boxes = new Box[2];
        boxes[0] = Box.createHorizontalBox();
        boxes[1] = Box.createHorizontalBox();

        boxes[0].setMaximumSize(new Dimension(DIM_X_CARDDECK, DIM_Y_CARDDECK));
        boxes[0].setMinimumSize(new Dimension(DIM_X_CARDDECK, DIM_Y_CARDDECK));
        boxes[0].setPreferredSize(new Dimension(DIM_X_CARDDECK, DIM_Y_CARDDECK));

        boxes[1].setPreferredSize(new Dimension(700, DIM_Y_CARDDECK));
        boxes[1].setMinimumSize(new Dimension(700, DIM_Y_CARDDECK));
        boxes[1].setMaximumSize(new Dimension(700, DIM_Y_CARDDECK));

    }

    private void setupLayout() {
        setOpaque(false);
        boxes[0].add(deckimage);
        boxes[1].add(cardimage);

        content.setOpaque(false);

        content.add(boxes[0], BorderLayout.WEST);
        content.add(boxes[1], BorderLayout.EAST);
        add(content);

        validate();
    }

    @Override
    public void update(Observable o, Object o1) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

class DeckCardImage extends JPanel implements Observer {

    private Image image = null;
    private ObservableGame observableGame;

    public DeckCardImage(ObservableGame observableGame) {
        this.observableGame = observableGame;
        this.observableGame.addObserver(this);

        setupComponents();
        setupLayout();
    }

    public void setupComponents() {
        try {
            image = javax.imageio.ImageIO.read(new java.net.URL(getClass().getResource("Images/CardDeck.png"), "CardDeck.png"));
        } catch (MalformedURLException ex) {
            Logger.getLogger(FirstMenuPanel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FirstMenuPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setupLayout() {
        setOpaque(false);
    }

    @Override
    public void paintComponent(Graphics g) {
        g.drawImage(image, 1, 1, image.getWidth(this) - 50, image.getHeight(this) - 50, this);
    }

    @Override
    public void update(Observable o, Object o1) {
        if (observableGame.getState() instanceof AwaitTopCardToBeDrawnPanel) {
            if (observableGame.getNCards() == 1) {
                try {
                    image = javax.imageio.ImageIO.read(new java.net.URL(getClass().getResource("Images/BackCard.png"), "BackCard.png"));
                } catch (MalformedURLException ex) {
                    Logger.getLogger(FirstMenuPanel.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(FirstMenuPanel.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
}

class CardImage extends JPanel implements Observer {

    private Image image = null;
    private ObservableGame observableGame;

    public CardImage(ObservableGame observableGame) {
        this.observableGame = observableGame;
        this.observableGame.addObserver(this);

        setupComponents();
        setupLayout();
    }

    public void setupComponents() {
        try {
            image = javax.imageio.ImageIO.read(new java.net.URL(getClass().getResource("Images/unknownCard.png"), "unknownCard.png"));
        } catch (MalformedURLException ex) {
            Logger.getLogger(FirstMenuPanel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FirstMenuPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setupLayout() {
    }

    @Override
    public void paintComponent(Graphics g) {
        g.drawImage(image, 1, 1, image.getWidth(this) - 20, image.getHeight(this) - 20, this);
    }

    @Override
    public void update(Observable o, Object o1) {
        if (observableGame.getState() instanceof AwaitTopCardToBeDrawn) {
            try {
                image = javax.imageio.ImageIO.read(new java.net.URL(getClass().getResource("Images/" + observableGame.getAtualCard().getImageName()), observableGame.getAtualCard().getImageName()));
            } catch (MalformedURLException ex) {
                Logger.getLogger(FirstMenuPanel.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(FirstMenuPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
}
