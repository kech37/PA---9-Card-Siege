/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.Gui;

import Logic.ObservableGame;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import static ui.Gui.Constants.*;

/**
 *
 * @author andre
 */
public class EnemyJPanel extends JPanel implements Observer {

    private ObservableGame observableGame;
    private ImageIcon image;
    private Map<Integer, JLabel> enemyBlocks;
    private JLabel enemy;

    public EnemyJPanel(ObservableGame observableGame) {
        this.observableGame = observableGame;
        this.observableGame.addObserver(this);
        setupComponents();
        setupLayout();
    }

    public void setupComponents() {
        image = new ImageIcon(getClass().getResource("Images/EnemyCard.png"));
        enemyBlocks = new HashMap<>();
        enemy = new JLabel();
    }

    public void setupLayout() {
        setOpaque(false);
        setMinimumSize(new Dimension(DIM_X_ENEMYSTATUS, DIM_Y_ENEMYSTATUS));
        setMaximumSize(new Dimension(DIM_X_ENEMYSTATUS, DIM_Y_ENEMYSTATUS));
        setPreferredSize(new Dimension(DIM_X_ENEMYSTATUS, DIM_Y_ENEMYSTATUS));
        setLayout(null);
        int x = (this.getWidth() - image.getIconWidth()) / 2;

        CreateGrid();

        add(enemy);
    }

    public void CreateGrid() {
        int aux = 21;
        int aux1 = 11;
        int aux2 = 1;
        int valuetemp = 0;
        for (int i = 18; i > 0; i--) {
            JLabel temp = new JLabel();
            enemy.add(temp);

            if (i < 3 || i < 16) {

                if (i == 4 || i == 7 || i == 10 || i == 13) {
                    valuetemp = aux;
                    aux++;
                } else {
                    if (i == 5 || i == 8 || i == 11 || i == 14) {
                        valuetemp = aux1;
                        aux1++;
                    } else {
                        valuetemp = aux2;
                        aux2++;
                    }
                }

                enemyBlocks.put(valuetemp, temp);
                enemyBlocks.get(valuetemp).setBorder(new LineBorder(Color.BLACK));
                enemyBlocks.get(valuetemp).setMinimumSize(new Dimension(DIM_X_QUADRICULA_AREA, DIM_Y_QUADRICULA_AREA));
                enemyBlocks.get(valuetemp).setPreferredSize(new Dimension(DIM_X_QUADRICULA_AREA, DIM_Y_QUADRICULA_AREA));
                enemyBlocks.get(valuetemp).setMaximumSize(new Dimension(DIM_X_QUADRICULA_AREA, DIM_Y_QUADRICULA_AREA));
            }
        }

        enemy.setMinimumSize(new Dimension(image.getIconWidth(), image.getIconHeight()));
        enemy.setPreferredSize(new Dimension(image.getIconWidth(), image.getIconHeight()));
        enemy.setMaximumSize(new Dimension(image.getIconWidth(), image.getIconHeight()));
        enemy.setLayout(new GridLayout(6, 3, 15, 15));
    }

    @Override
    public void paintComponent(Graphics g) {
        int x = (this.getWidth() - image.getIconWidth()) / 2;
        g.drawImage(image.getImage(), x, 1, image.getIconWidth(), image.getIconHeight(), this);
        enemy.setBounds(x, -8, image.getIconWidth(), image.getIconHeight());
    }

    @Override
    public void update(Observable o, Object o1) {
        enemyBlocks.get(observableGame.getEnemyCard().getBatteringRam().getPosition()).setIcon(new ImageIcon(getClass().getResource("Images/Token_24x26.png")));
        enemyBlocks.get(observableGame.getEnemyCard().getLadders().getPosition() + 10).setIcon(new ImageIcon(getClass().getResource("Images/Token_24x26.png")));
        enemyBlocks.get(observableGame.getEnemyCard().getSiegeTower().getPosition() + 20).setIcon(new ImageIcon(getClass().getResource("Images/Token_24x26.png")));
    }
}
