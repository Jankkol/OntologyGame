package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Jan Kakol on 2015-06-11.
 */
public class GameMenuFrame extends AbstractFrame {

    public GameMenuFrame(){
        super();
        setLayout(new FlowLayout());
        JPanel jPanel = new ImagePanel();
        add(jPanel);
        final JButton button = new JButton("Przycisk 1");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                button.setBackground(Color.RED);
            }
        });
        add(button);
        setVisible(true);
    }
}
