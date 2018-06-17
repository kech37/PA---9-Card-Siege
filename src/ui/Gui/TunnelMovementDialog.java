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

public class TunnelMovementDialog extends JDialog {
    private ObservableGame observableGame;
    private JLabel t;
    private JButton btFree, btFast;
    private JPanel bottom;
    private JPanel central;

    public TunnelMovementDialog(ObservableGame observableGame) {
        this.observableGame = observableGame;
        
        setupComponents();
        setupLayout();
    }
     private void setupComponents() {
        t = new JLabel("Movement:", SwingConstants.CENTER);
        btFree = new JButton("Free");
        btFast = new JButton("Fast");
        bottom = new JPanel();
        central = new JPanel();
    }

    private void setupLayout() {
        setPreferredSize(new Dimension(300, 200));
        
        btFree.setEnabled(observableGame.isFreeMovement());
        
        bottom.setLayout(new GridLayout(1, 2));
        bottom.add(btFree);
        bottom.add(btFast);

        central.setLayout(new GridLayout(2, 1));
        central.add(t);
        central.add(bottom);

        add(central);

        btFree.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                observableGame.TunnelMovementOptionSelection(2);
                dispose();
            }
        });

        btFast.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                observableGame.TunnelMovementOptionSelection(1);
                dispose();
            }
        });
    }
    
}
