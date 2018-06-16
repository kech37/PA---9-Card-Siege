/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.Gui;

import Logic.States.AwaitEnemyTrackSelectionForArchersAttack;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;

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
      lGameOver = new JLabel("<html><font color='red'>Game Over</font></html>");
    }

    private void setupLayout() {
         setPreferredSize(new Dimension(600, 400));
         setLayout(new GridLayout(2,1));
         
         setBackground(Color.RED);
         
         lGameOver.setFont((new Font(lGameOver.getName(), Font.PLAIN, 50))); 
         
         finish.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.exit(0);
            }
         });
         
         add(lGameOver);
         add(finish);
    }
    
    
    
}
