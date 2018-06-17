/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.Gui;

import Logic.Game;
import Logic.ObservableGame;
import Logic.States.AwaitActionSelection;
import Logic.States.AwaitTopCardToBeDrawn;
import Logic.States.GameOver;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;
import static ui.Gui.Constants.DIM_X_ENEMYSTATUS;
import static ui.Gui.Constants.DIM_X_FRAME;
import static ui.Gui.Constants.DIM_Y_ENEMYSTATUS;
import static ui.Gui.Constants.DIM_Y_FRAME;

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
    JButton btTradeActionPoint;
    JButton btNone;
    JButton btNone1;
    JButton btNextTurn;

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
        btTradeActionPoint = new JButton("Trade Action Points");
        btNextTurn = new JButton("Next Turn");
        btNone = new JButton("");
        btNone1 = new JButton("");

        btNone.setEnabled(false);
        btNone1.setEnabled(false);
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
        add(btTradeActionPoint);
        add(btNone);
        add(btNextTurn);
        add(btNone1);

        btTradeActionPoint.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                observableGame.tradeActionPoint();
            }
        });

        btArchersAttack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ev) {
                observableGame.ArchersAttack();
                SelectEnemyDialog dialog = new SelectEnemyDialog(observableGame);
                dialog.setUndecorated(true);
                dialog.pack();

                dialog.setModal(true);
                dialog.setLocation(new Point(((DIM_X_FRAME - 600) / 2), ((DIM_Y_FRAME - 400) / 2)));
                dialog.setVisible(true);

                observableGame.SetUpdate();

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

        btNextTurn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                observableGame.NextTurn();
            }
        });

        setLayout(new GridLayout(5, 3));
    }

    @Override
    public void update(Observable o, Object o1) {
        if (observableGame.getState() instanceof AwaitTopCardToBeDrawn) {
            observableGame.AwaitTopCardToBeDrawnAction();
        } else {
            if (observableGame.getState() instanceof GameOver) {
                GameOverDialog dialog = new GameOverDialog();
                dialog.setUndecorated(true);
                dialog.pack();

                dialog.setModal(true);
                dialog.setLocation(new Point(((DIM_X_FRAME - 600) / 2), ((DIM_Y_FRAME - 400) / 2)));
                dialog.setVisible(true);

                observableGame.leaveGame();
                InicialMenuJFrame inicio = new InicialMenuJFrame(new ObservableGame(new Game()), 1, 1);
            }
        }
        if (observableGame.getEnemyCard().isCardsOnCircle()) {
                btBoilingWaterAttack.setEnabled(false);
        } else {
              btBoilingWaterAttack.setEnabled(true);
        }
    }

}
