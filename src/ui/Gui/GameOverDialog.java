/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.Gui;

import Logic.Game;
import Logic.ObservableGame;
import Logic.States.AwaitEnemyTrackSelectionForArchersAttack;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javafx.beans.Observable;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 *
 * @author andre
 */
public class GameOverDialog extends JDialog implements Constants{
    
    private JButton finish;
    private JLabel lGameOver;
    
    public GameOverDialog() {
        setupComponents();
        setupLayout();
    }

    private void setupComponents() {
      finish = new JButton("Finish");
      lGameOver = new JLabel("<html><font color='white'>Game Over</font></html>", SwingConstants.CENTER);
    }

    private void setupLayout() {
         setPreferredSize(new Dimension(600, 400));
         
         
         JPanel temp = new JPanel();
         temp.setLayout(new GridLayout(2,1));
         temp.setBackground(Color.RED);
         
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
