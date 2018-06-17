/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.Gui;

import Logic.ObservableGame;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import static ui.Gui.Constants.*;

/**
 *
 * @author andre
 */
public class EnemyJPanel extends JPanel implements Observer {

    private ObservableGame observableGame;
    private ImageIcon image;
    private ImageIcon imageBtCube;
    private ImageIcon imageLaddersCube;
    private ImageIcon imageSiegeTowerCube;
    private ImageIcon imageTrebuchetCube;

    public EnemyJPanel(ObservableGame observableGame) {
        this.observableGame = observableGame;
        this.observableGame.addObserver(this);
        setupComponents();
        setupLayout();
    }

    public void setupComponents() {
        image = new ImageIcon(getClass().getResource("Images/EnemyCard.png"));
        imageBtCube = new ImageIcon(getClass().getResource("Images/BtCube.png"));
        imageLaddersCube = new ImageIcon(getClass().getResource("Images/LaddersCube.png"));
        imageSiegeTowerCube = new ImageIcon(getClass().getResource("Images/SiegeTowerCube.png"));
        imageTrebuchetCube = new ImageIcon(getClass().getResource("Images/TrebuchetCube.png"));
    }

    public void setupLayout() {
        setOpaque(false);
        setMinimumSize(new Dimension(image.getIconWidth(), image.getIconHeight()));
        setMaximumSize(new Dimension(image.getIconWidth(), image.getIconHeight()));
        setPreferredSize(new Dimension(image.getIconWidth(), image.getIconHeight()));
        setLayout(null);
    }

    @Override
    public void paintComponent(Graphics g) {
        int x = (this.getWidth() - image.getIconWidth()) / 2;
        g.drawImage(image.getImage(), x, 1, image.getIconWidth(), image.getIconHeight(), this);

        paintLadder(g, observableGame.getEnemyCard().getLadders().getPosition(), x);
        paintBT(g, observableGame.getEnemyCard().getBatteringRam().getPosition(), x);
        paintSiegeTower(g, observableGame.getEnemyCard().getSiegeTower().getPosition(), x);
        paintTrebuchet(g, observableGame.getEnemyCard().getTrebuchet().getHowMany(), x);
    }

    @Override
    public void update(Observable o, Object o1) {
        paintComponent(this.getGraphics());
    }

    public void paintLadder(Graphics g, int value, int x) {
        switch (value) {
            case 4:
                g.drawImage(imageLaddersCube.getImage(), x + 12, 220, imageBtCube.getIconWidth(), imageBtCube.getIconHeight(), this);
                break;
            case 3:
                g.drawImage(imageLaddersCube.getImage(), x + 12, 165, imageBtCube.getIconWidth(), imageBtCube.getIconHeight(), this);
                break;
            case 2:
                g.drawImage(imageLaddersCube.getImage(), x + 12, 110, imageBtCube.getIconWidth(), imageBtCube.getIconHeight(), this);
                break;
            case 1:
                g.drawImage(imageLaddersCube.getImage(), x + 12, 55, imageBtCube.getIconWidth(), imageBtCube.getIconHeight(), this);
                break;
            case 0:
                g.drawImage(imageLaddersCube.getImage(), x + 75, 5, imageBtCube.getIconWidth(), imageBtCube.getIconHeight(), this);
                break;
        }
    }

    public void paintBT(Graphics g, int value, int x) {
        switch (value) {
            case 4:
                g.drawImage(imageBtCube.getImage(), x + 93, 220, imageBtCube.getIconWidth(), imageBtCube.getIconHeight(), this);
                break;
            case 3:
                g.drawImage(imageBtCube.getImage(), x + 93, 165, imageBtCube.getIconWidth(), imageBtCube.getIconHeight(), this);
                break;
            case 2:
                g.drawImage(imageBtCube.getImage(), x + 93, 110, imageBtCube.getIconWidth(), imageBtCube.getIconHeight(), this);
                break;
            case 1:
                g.drawImage(imageBtCube.getImage(), x + 93, 55, imageBtCube.getIconWidth(), imageBtCube.getIconHeight(), this);
                break;
            case 0:
                g.drawImage(imageBtCube.getImage(), x + 115, 5, imageBtCube.getIconWidth(), imageBtCube.getIconHeight(), this);
                break;
        }

    }

    public void paintSiegeTower(Graphics g, int value, int x) {
        switch (value) {
            case 4:
                g.drawImage(imageSiegeTowerCube.getImage(), x + 173, 220, imageBtCube.getIconWidth(), imageBtCube.getIconHeight(), this);
                break;
            case 3:
                g.drawImage(imageSiegeTowerCube.getImage(), x + 173, 165, imageBtCube.getIconWidth(), imageBtCube.getIconHeight(), this);
                break;
            case 2:
                g.drawImage(imageSiegeTowerCube.getImage(), x + 173, 110, imageBtCube.getIconWidth(), imageBtCube.getIconHeight(), this);
                break;
            case 1:
                g.drawImage(imageSiegeTowerCube.getImage(), x + 173, 55, imageBtCube.getIconWidth(), imageBtCube.getIconHeight(), this);
                break;
            case 0:
                g.drawImage(imageSiegeTowerCube.getImage(), x + 115, 5, imageBtCube.getIconWidth(), imageBtCube.getIconHeight(), this);
                break;
        }
    }

    public void paintTrebuchet(Graphics g, int value, int x) {
        switch (value) {
            case 1:
                g.drawImage(imageTrebuchetCube.getImage(), x + 12, 285, imageBtCube.getIconWidth(), imageBtCube.getIconHeight(), this);
                break;
            case 2:
                g.drawImage(imageTrebuchetCube.getImage(), x + 93, 285, imageBtCube.getIconWidth(), imageBtCube.getIconHeight(), this);
                break;
            case 3:
                g.drawImage(imageTrebuchetCube.getImage(), x + 173, 285, imageBtCube.getIconWidth(), imageBtCube.getIconHeight(), this);
                break;

        }
    }
}
