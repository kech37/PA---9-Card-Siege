/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.Gui;

import Logic.Cards.EventCards.Events.TrebuchetAttackEvent;
import Logic.ObservableGame;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Observable;
import java.util.Observer;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import static ui.Gui.Constants.DIM_X_ENEMYSTATUS;
import static ui.Gui.Constants.DIM_Y_ENEMYSTATUS;

/**
 *
 * @author andre
 */
public class DicePanel extends JPanel implements Observer {

    private ObservableGame observableGame;
    private ImageIcon image;

    public DicePanel(ObservableGame observableGame) {
        this.observableGame = observableGame;
        this.observableGame.addObserver(this);

        setupComponents();
        setupLayout();
    }

    private void setupComponents() {
        image = new ImageIcon(getClass().getResource("Images/dice-six-faces-one.png"));
    }

    private void setupLayout() {
        setMinimumSize(new Dimension(DIM_X_ENEMYSTATUS, DIM_Y_ENEMYSTATUS));
        setMaximumSize(new Dimension(DIM_X_ENEMYSTATUS, DIM_Y_ENEMYSTATUS));
        setPreferredSize(new Dimension(DIM_X_ENEMYSTATUS, DIM_Y_ENEMYSTATUS));
    }

    @Override
    protected void paintComponent(Graphics grphcs) {
        int x = (this.getWidth() - image.getIconWidth()) / 2;
        grphcs.drawImage(image.getImage(), x, 20, image.getIconWidth(), image.getIconHeight(), this);
    }

    @Override
    public void update(Observable o, Object o1) {

        switch (observableGame.getDiceNumber()) {
            case 0:
                image = new ImageIcon(getClass().getResource("Images/dice-six-faces.png"));
                break;
            case 1:
                image = new ImageIcon(getClass().getResource("Images/dice-six-faces-one.png"));
                break;
            case 2:
                image = (new ImageIcon(getClass().getResource("Images/dice-six-faces-two.png")));
                break;
            case 3:
                image = (new ImageIcon(getClass().getResource("Images/dice-six-faces-three.png")));
                break;
            case 4:
                image = (new ImageIcon(getClass().getResource("Images/dice-six-faces-four.png")));
                break;
            case 5:
                image = (new ImageIcon(getClass().getResource("Images/dice-six-faces-five.png")));
                break;
            case 6:
                image = (new ImageIcon(getClass().getResource("Images/dice-six-faces-six.png")));
                break;
            default:
                image = (new ImageIcon(getClass().getResource("Images/dice-six-faces.png")));
                break;
        }

        paintComponent(this.getGraphics());
    }

}
