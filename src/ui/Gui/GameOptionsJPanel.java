/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.Gui;

import Logic.ObservableGame;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JButton;
import javax.swing.JPanel;
import static ui.Gui.Constants.DIM_X_ENEMYSTATUS;
import static ui.Gui.Constants.DIM_Y_ENEMYSTATUS;

/**
 *
 * @author andre
 */
public class GameOptionsJPanel extends JPanel implements Observer {

    private ObservableGame observableGame;

    JButton btArchersAttack;
    JButton btBoilingWaterAttack;
    JButton btCloseCombatAttack;
    JButton btCoupure;
    JButton btRallyTroops;
    JButton btTunnelMovement;
    JButton btSupplyRaid;
    JButton btSabotage;

    public GameOptionsJPanel(ObservableGame observableGame) {
        this.observableGame = observableGame;
        this.observableGame.addObserver(this);

        setupComponents();
        setupLayout();
    }

    public void setupComponents() {
        btArchersAttack = new JButton("Archers Attack");
        btBoilingWaterAttack = new JButton("Boiling Water Attack");
        btCloseCombatAttack = new JButton("Close Combat Attack");
        btCoupure = new JButton("Coupure");
        btRallyTroops = new JButton("Rally Troops");
        btTunnelMovement = new JButton("Tunnel Movement");
        btSupplyRaid = new JButton("Supply Raid");
        btSabotage = new JButton("Sabotage");
    }

    public void setupLayout() {
        setOpaque(false);
        setMinimumSize(new Dimension(DIM_X_ENEMYSTATUS, DIM_Y_ENEMYSTATUS));
        setMaximumSize(new Dimension(DIM_X_ENEMYSTATUS, DIM_Y_ENEMYSTATUS));
        setPreferredSize(new Dimension(DIM_X_ENEMYSTATUS, DIM_Y_ENEMYSTATUS));

        add(btArchersAttack);
        add(btBoilingWaterAttack);
        add(btCloseCombatAttack);
        add(btCoupure);
        add(btRallyTroops);
        add(btTunnelMovement);
        add(btSupplyRaid);
        add(btSabotage);

        btArchersAttack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ev) {
                observableGame.ArchersAttack();
            }
        });

        btBoilingWaterAttack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                observableGame.BoilingWaterAttack();
            }
        });

        btCloseCombatAttack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                observableGame.CloseCombatAreaAtack();
            }
        });

        btCoupure.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                observableGame.Coupure();
            }
        });

        btRallyTroops.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                observableGame.RallyTroops();
            }
        });

        btTunnelMovement.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                observableGame.TunnelMovement();
            }
        });

        btSupplyRaid.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                observableGame.SupplyRaid();
            }
        });

        btSabotage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                observableGame.Sabotage();
            }
        });

        setLayout(new GridLayout(4, 2));
    }

    @Override
    public void update(Observable o, Object o1) {

    }

}
