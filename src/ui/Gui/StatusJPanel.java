/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.Gui;

import Logic.ObservableGame;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Label;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Observable;
import java.util.Observer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import static ui.Gui.Constants.DIM_X_ENEMYSTATUS;
import static ui.Gui.Constants.DIM_Y_ENEMYSTATUS;

/**
 *
 * @author andre
 */
public class StatusJPanel extends JPanel implements Observer {

    private ObservableGame observableGame;
    private ImageIcon image;
    private ImageIcon imageSatus;

    public StatusJPanel(ObservableGame observableGame) {
        this.observableGame = observableGame;
        this.observableGame.addObserver(this);
        setupComponents();
        setupLayout();
    }

    public void setupComponents() {
        image = new ImageIcon(getClass().getResource("Images/StatusCard.png"));
        imageSatus = new ImageIcon(getClass().getResource("Images/9Cube.png"));
    }

    public void setupLayout() {
        setOpaque(false);
        setMinimumSize(new Dimension(DIM_X_ENEMYSTATUS, DIM_Y_ENEMYSTATUS));
        setMaximumSize(new Dimension(DIM_X_ENEMYSTATUS, DIM_Y_ENEMYSTATUS));
        setPreferredSize(new Dimension(DIM_X_ENEMYSTATUS, DIM_Y_ENEMYSTATUS));
    }

    @Override
    public void paintComponent(Graphics g) {
        int x = (this.getWidth() - image.getIconWidth()) / 2;
        try {
            g.drawImage(image.getImage(), x, 1, image.getIconWidth(), image.getIconHeight(), this);

            paintWallStrength(g, observableGame.getStatusCard().getWallStrenght(), x);
            paintMorale(g, observableGame.getStatusCard().getMorale(), x);
            paintSupplies(g, observableGame.getStatusCard().getSupplies(), x);
            paintSuppliesLevel(g, observableGame.getStatusCard().getSuppliesLevel(), x);
            //paintTunnelMovement(g, observableGame.getStatusCard().getTunnel(),x);
            paintTunnelMovement(g, 0, x);
            paintTunnelMovement(g, 1, x);
            paintTunnelMovement(g, 2, x);
            paintTunnelMovement(g, 3, x);
        } catch (Exception i) {

        }

    }

    @Override
    public void update(Observable o, Object o1) {
        paintComponent(this.getGraphics());
    }

    public void paintWallStrength(Graphics g, int value, int x) {
        switch (value) {
            case 0:
                g.drawImage(imageSatus.getImage(), x + 85, 230, imageSatus.getIconWidth(), imageSatus.getIconHeight(), this);
                break;
            case 1:
                g.drawImage(imageSatus.getImage(), x + 10, 170, imageSatus.getIconWidth(), imageSatus.getIconHeight(), this);
                break;
            case 2:
                g.drawImage(imageSatus.getImage(), x + 10, 117, imageSatus.getIconWidth(), imageSatus.getIconHeight(), this);
                break;
            case 3:
                g.drawImage(imageSatus.getImage(), x + 10, 64, imageSatus.getIconWidth(), imageSatus.getIconHeight(), this);
                break;
            case 4:
                g.drawImage(imageSatus.getImage(), x + 10, 7, imageSatus.getIconWidth(), imageSatus.getIconHeight(), this);
                break;
        }
    }

    public void paintMorale(Graphics g, int value, int x) {
        switch (value) {
            case 0:
                g.drawImage(imageSatus.getImage(), x + 85, 230, imageSatus.getIconWidth(), imageSatus.getIconHeight(), this);
                break;
            case 1:
                g.drawImage(imageSatus.getImage(), x + 85, 170, imageSatus.getIconWidth(), imageSatus.getIconHeight(), this);
                break;
            case 2:
                g.drawImage(imageSatus.getImage(), x + 85, 117, imageSatus.getIconWidth(), imageSatus.getIconHeight(), this);
                break;
            case 3:
                g.drawImage(imageSatus.getImage(), x + 85, 64, imageSatus.getIconWidth(), imageSatus.getIconHeight(), this);
                break;
            case 4:
                g.drawImage(imageSatus.getImage(), x + 85, 7, imageSatus.getIconWidth(), imageSatus.getIconHeight(), this);
                break;
        }
    }

    public void paintSupplies(Graphics g, int value, int x) {
        switch (value) {
            case 0:
                g.drawImage(imageSatus.getImage(), x + 85, 230, imageSatus.getIconWidth(), imageSatus.getIconHeight(), this);
                break;
            case 1:
                g.drawImage(imageSatus.getImage(), x + 162, 170, imageSatus.getIconWidth(), imageSatus.getIconHeight(), this);
                break;
            case 2:
                g.drawImage(imageSatus.getImage(), x + 162, 117, imageSatus.getIconWidth(), imageSatus.getIconHeight(), this);
                break;
            case 3:
                g.drawImage(imageSatus.getImage(), x + 162, 64, imageSatus.getIconWidth(), imageSatus.getIconHeight(), this);
                break;
            case 4:
                g.drawImage(imageSatus.getImage(), x + 162, 7, imageSatus.getIconWidth(), imageSatus.getIconHeight(), this);
                break;
        }
    }

    private void paintSuppliesLevel(Graphics g, int value, int x) {
        switch (value) {
            case 0:
                g.drawImage(imageSatus.getImage(), x + 168, 265, imageSatus.getIconWidth(), imageSatus.getIconHeight(), this);
                break;
            case 1:
                g.drawImage(imageSatus.getImage(), x + 168, 245, imageSatus.getIconWidth(), imageSatus.getIconHeight(), this);
                break;
            case 2:
                g.drawImage(imageSatus.getImage(), x + 168, 285, imageSatus.getIconWidth(), imageSatus.getIconHeight(), this);
                break;
        }
    }

    private void paintTunnelMovement(Graphics g, int value, int x) {
        switch (value) {
            case 0:
                g.drawImage(imageSatus.getImage(), x, 285, imageSatus.getIconWidth(), imageSatus.getIconHeight(), this);
                break;
            case 1:
                g.drawImage(imageSatus.getImage(), x + 15, 285, imageSatus.getIconWidth(), imageSatus.getIconHeight(), this);
                break;
            case 2:
                g.drawImage(imageSatus.getImage(), x + 65, 285, imageSatus.getIconWidth(), imageSatus.getIconHeight(), this);
                break;
            case 3:
                g.drawImage(imageSatus.getImage(), x + 112, 285, imageSatus.getIconWidth(), imageSatus.getIconHeight(), this);
                break;
        }
    }

}
