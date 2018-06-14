/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.Gui;

import Logic.ObservableGame;
import Logic.States.AwaitBegining;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JFrame;
import static ui.Gui.Constants.*;

/**
 *
 * @author andre
 */
public class InicialMenuJFrame extends JFrame implements Observer {

    private ObservableGame observableGame;
    private InicialMenuJPanel panel;

    public InicialMenuJFrame(ObservableGame j, int x, int y) {
        this(j, x, y, DIM_X_MENU, DIM_Y_MENU);
    }

    public InicialMenuJFrame(ObservableGame j, int x, int y, int width, int height) {
        super("Menu Principal");

        observableGame = j;

        observableGame.addObserver(this);

        setResizable(false);

        Container cp = getContentPane();

        panel = new InicialMenuJPanel(observableGame);

        cp.add(panel, BorderLayout.CENTER);
        setSize(width, height);
        setLocationRelativeTo(null);

        setMinimumSize(new Dimension(width, height));
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        validate();
    }

    @Override
    public void update(Observable o, Object o1) {
        setVisible(observableGame.getState() instanceof AwaitBegining);
    }

}
