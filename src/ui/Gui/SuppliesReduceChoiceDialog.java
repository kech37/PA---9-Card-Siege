/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.Gui;

import Logic.ObservableGame;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 *
 * @author andre
 */
public class SuppliesReduceChoiceDialog extends JDialog{
    
    private ObservableGame observableGame;
    private JLabel t;
    private JButton btYes, btNo;
    private JPanel bottom;
    private JPanel central;

    public SuppliesReduceChoiceDialog(ObservableGame observableGame) {
        this.observableGame = observableGame;

        setupComponents();
        setupLayout();
    }

    private void setupComponents() {
        t = new JLabel("Reduce Supplies by 1 to get a +1 DRM:", SwingConstants.CENTER);
        btYes = new JButton("Yes");
        btNo = new JButton("No");
        bottom = new JPanel();
        central = new JPanel();
    }

    private void setupLayout() {
        setPreferredSize(new Dimension(300, 200));
        bottom.setLayout(new GridLayout(1, 2));
        bottom.add(btYes);
        bottom.add(btNo);

        central.setLayout(new GridLayout(2, 1));
        central.add(t);
        central.add(bottom);

        add(central);

        btYes.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                observableGame.SuppliesReduceChoice(1);
                dispose();
            }
        });

        btNo.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                observableGame.SuppliesReduceChoice(2);
                dispose();
            }
        });
    }

    
}
