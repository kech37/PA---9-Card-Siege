/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.Gui;

import Logic.ObservableGame;
import Logic.States.AwaitTopCardToBeDrawn;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JPanel;

public class DeckNCardJPanel extends JPanel implements Observer {

    private final ObservableGame observableGame;
    private DeckCardImageJPanel deckimage;
    private CardImageJPanel cardimage;

    public DeckNCardJPanel(ObservableGame observableGame) {
        this.observableGame = observableGame;
        setupComponents();
        setupLayout();
    }

    private void setupComponents() {
        deckimage = new DeckCardImageJPanel(observableGame);
        cardimage = new CardImageJPanel(observableGame);
    }

    private void setupLayout() {
        /*GridBagLayout layout = new GridBagLayout();
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.CENTER;        
        layout.setConstraints(this, constraints);
        
        setLayout(layout);*/
        
        setLayout(new GridLayout(1, 2, 5, 0));

        add(deckimage);
        add(cardimage);
    }

    @Override
    public void update(Observable o, Object o1) {

    }

}
