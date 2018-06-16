/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.Gui;

import Logic.ObservableGame;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.util.Observable;
import java.util.Observer;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import static ui.Gui.Constants.DIM_X_ENEMYSTATUS;
import static ui.Gui.Constants.DIM_Y_ENEMYSTATUS;

/**
 *
 * @author andre
 */
public class DiceActionPointPanel extends JPanel implements Observer {

    private ObservableGame observableGame;
    private DicePanel dice;
    private JLabel actionPoint;
    private JLabel day;

    public DiceActionPointPanel(ObservableGame observableGame) {
        this.observableGame = observableGame;
        this.observableGame.addObserver(this);

        setupComponents();
        setupLayout();
    }

    private void setupComponents() {
        dice = new DicePanel(observableGame);
        actionPoint = new JLabel("", SwingConstants.CENTER);
        day = new JLabel("Day: " + (observableGame.getDay() + 1), SwingConstants.CENTER);
    }

    private void setupLayout() {
        setLayout(new GridLayout(2, 1));
        setMinimumSize(new Dimension(DIM_X_ENEMYSTATUS, DIM_Y_ENEMYSTATUS));
        setMaximumSize(new Dimension(DIM_X_ENEMYSTATUS, DIM_Y_ENEMYSTATUS));
        setPreferredSize(new Dimension(DIM_X_ENEMYSTATUS, DIM_Y_ENEMYSTATUS));

        actionPoint.setFont((new Font(actionPoint.getName(), Font.PLAIN, 40)));
        day.setFont((new Font(day.getName(), Font.PLAIN, 40)));

        JPanel labelpanel = new JPanel();
        labelpanel.setLayout(new GridLayout(2, 1));

        labelpanel.add(day);
        labelpanel.add(actionPoint);

        add(dice);
        add(labelpanel);
    }

    @Override
    public void update(Observable o, Object o1) {
        actionPoint.setText("Action Points: " + observableGame.getAtualCard().getEvents().get(observableGame.getDay()).getActionPointAllowance());
        day.setText("Day: " + (observableGame.getDay() + 1));
    }
}
