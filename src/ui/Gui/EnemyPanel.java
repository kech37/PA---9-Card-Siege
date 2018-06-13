/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.Gui;

import Logic.ObservableGame;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Observable;
import java.util.Observer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import static ui.Gui.Constants.*;

/**
 *
 * @author andre
 */
public class EnemyPanel extends JPanel implements Observer {

    private ObservableGame observableGame;
    private ImageIcon image;

    public EnemyPanel(ObservableGame observableGame) {
        this.observableGame = observableGame;
        this.observableGame.addObserver(this);
        setupComponents();
        setupLayout();
    }

    public void setupComponents() {

        image = new ImageIcon(getClass().getResource("Images/EnemyCard.png"));
    }

    public void setupLayout() {
        setOpaque(false);

        setMinimumSize(new Dimension(DIM_X_ENEMYSTATUS, DIM_Y_ENEMYSTATUS));
        setMaximumSize(new Dimension(DIM_X_ENEMYSTATUS, DIM_Y_ENEMYSTATUS));
        setPreferredSize(new Dimension(DIM_X_ENEMYSTATUS, DIM_Y_ENEMYSTATUS));

        add(new JLabel(image));

    }

    @Override
    public void paintComponent(Graphics g) {
        // g.drawImage(image, 1, 1, image.getWidth(this) - 50, image.getHeight(this) - 50, this);
    }

    @Override
    public void update(Observable o, Object o1) {

    }

}
