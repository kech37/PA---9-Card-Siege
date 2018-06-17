/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.Gui;

import Logic.ObservableGame;
import Logic.States.AwaitEnemyTrackSelectionForArchersAttack;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;

public class SelectEnemyDialog extends JDialog implements Constants {

    private ObservableGame observableGame;
    private JLabel ladders, bT, siegegTower;
    private JPanel options;

    public SelectEnemyDialog(ObservableGame observableGame) {
        this.observableGame = observableGame;

        setupComponents();
        setupLayout();
    }

    private void setupComponents() {
        ImageIcon imageLadders = new ImageIcon(getClass().getResource("Images/Ladders.png"));
        ImageIcon imageBt = new ImageIcon(getClass().getResource("Images/Bt.png"));
        ImageIcon imageSiegeTower = new ImageIcon(getClass().getResource("Images/SiegeTower.png"));

        ladders = new JLabel(imageLadders);
        bT = new JLabel(imageBt);
        siegegTower = new JLabel(imageSiegeTower);

        options = new JPanel();
    }

    private void setupLayout() {
        options.setLayout(new GridLayout(1, 3));
        setPreferredSize(new Dimension(600, 400));
        Box b1 = Box.createHorizontalBox();
        Box b2 = Box.createHorizontalBox();
        Box b3 = Box.createHorizontalBox();

        b1.add(ladders);
        b2.add(bT);
        b3.add(siegegTower);

        options.add(ladders);
        options.add(bT);
        options.add(siegegTower);

        options.setBorder(new BevelBorder(1));

        setLayout(new GridLayout(2, 1));
        JPanel text = new JPanel();
      
        JLabel t = new JLabel("Select Enemy Track:", SwingConstants.CENTER);
        t.setFont(new Font(t.getName(), Font.BOLD, 30));
        text.add(t, BorderLayout.CENTER);
        t.setBounds(120, 50, 350, 100);
        text.setLayout(null);

        add(text, BorderLayout.CENTER);
        add(options);

        ladders.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (observableGame.getState() instanceof AwaitEnemyTrackSelectionForArchersAttack) {
                    observableGame.ArchersAttackTrackSelection(2);
                    dispose();
                }

            }

            @Override
            public void mouseEntered(MouseEvent me) {
                ladders.setIcon(new ImageIcon(getClass().getResource("Images/LaddersSelect.png")));

            }

            @Override
            public void mouseExited(MouseEvent me) {
                ladders.setIcon(new ImageIcon(getClass().getResource("Images/Ladders.png")));
            }

        });

        bT.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (observableGame.getState() instanceof AwaitEnemyTrackSelectionForArchersAttack) {
                    observableGame.ArchersAttackTrackSelection(1);
                    dispose();
                }

            }

            @Override
            public void mouseEntered(MouseEvent me) {
                bT.setIcon(new ImageIcon(getClass().getResource("Images/BtSelect.png")));

            }

            @Override
            public void mouseExited(MouseEvent me) {
                bT.setIcon(new ImageIcon(getClass().getResource("Images/Bt.png")));
            }

        });

        siegegTower.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (observableGame.getState() instanceof AwaitEnemyTrackSelectionForArchersAttack) {
                    observableGame.ArchersAttackTrackSelection(3);
                    dispose();
                }

            }

            @Override
            public void mouseEntered(MouseEvent me) {
                siegegTower.setIcon(new ImageIcon(getClass().getResource("Images/SiegeTowerSelect.png")));

            }

            @Override
            public void mouseExited(MouseEvent me) {
                siegegTower.setIcon(new ImageIcon(getClass().getResource("Images/SiegeTower.png")));
            }

        });
    }
}
