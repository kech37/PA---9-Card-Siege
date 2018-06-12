/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.Gui;

import Logic.ObservableGame;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JFrame;
import static ui.Gui.Constants.*;

/**
 *
 * @author andre
 */
public class HomePageView extends JFrame implements Observer {

    private ObservableGame observableGame;
    private HomePagePanel panel;

    public HomePageView(ObservableGame j, int x, int y) {
        this(j, x, y, DIM_X_HOMEPAGE, DIM_Y_HOMEPAGE);
    }

    public HomePageView(ObservableGame j, int x, int y, int width, int height) {
        super("PaginaInicial");

        observableGame = j;

        observableGame.addObserver(this);

        Container cp = getContentPane();

        panel = new HomePagePanel(observableGame);

        cp.add(panel, BorderLayout.CENTER);
        setSize(width, height);
        setLocationRelativeTo(null);

        setMinimumSize(new Dimension(width, height));
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        observableGame.SetUpdate();
        
        validate();
    }

    @Override
    public void update(Observable o, Object o1) {

    }

}
