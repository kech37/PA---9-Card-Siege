/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.Gui;

import Logic.ObservableGame;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class NextDayDialog extends JDialog {

    private ObservableGame observable;
    private JButton finish;
    private JLabel lGameOver;

    public NextDayDialog(ObservableGame observable) {
        this.observable = observable;

        setupComponents();
        setupLayout();
    }

    private void setupComponents() {
        finish = new JButton("Continue");
        lGameOver = new JLabel("<html><font color='white'>Next Day</font></html>", SwingConstants.CENTER);
    }

    private void setupLayout() {
        setPreferredSize(new Dimension(600, 400));

        JPanel temp = new JPanel();
        temp.setLayout(new GridLayout(2, 1));
        temp.setBackground(Color.ORANGE);

        lGameOver.setFont((new Font(lGameOver.getName(), Font.BOLD, 50)));

        finish.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                dispose();

            }
        });

        temp.add(lGameOver);
        temp.add(finish);
        add(temp);
    }

}
