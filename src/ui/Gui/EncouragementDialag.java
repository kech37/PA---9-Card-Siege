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

public class EncouragementDialag extends JDialog {

    private ObservableGame observableGame;
    private JLabel t;
    private JButton btMorale, btSupplies;
    private JPanel bottom;
    private JPanel central;

    public EncouragementDialag(ObservableGame observableGame) {
        this.observableGame = observableGame;

        setupComponents();
        setupLayout();
    }

    private void setupComponents() {
        t = new JLabel("Reduce: ", SwingConstants.CENTER);
        btMorale = new JButton("Morale");
        btSupplies = new JButton("Supplies");
        bottom = new JPanel();
        central = new JPanel();
    }

    private void setupLayout() {
        setPreferredSize(new Dimension(300, 200));
        bottom.setLayout(new GridLayout(1, 2));
        bottom.add(btMorale);
        bottom.add(btSupplies);

        central.setLayout(new GridLayout(2, 1));
        central.add(t);
        central.add(bottom);

        add(central);

        btMorale.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                observableGame.Encouragement(1);
                dispose();
            }
        });

        btSupplies.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                observableGame.Encouragement(2);
                dispose();
            }
        });
    }

}
