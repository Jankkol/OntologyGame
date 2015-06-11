package gui;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Jan Kakol on 2015-06-11.
 */
public class GameMenuFrame extends JFrame {

    public GameMenuFrame(){
        super("Hello World");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 100);
        setLocation(50,50);
        setLayout(new FlowLayout());
        JPanel jPanel = new ImagePanel();
        add(jPanel);
        add(new JButton("Przycisk 1"));
        add(new JButton("Przycisk 2"));
        add(new JButton("Przycisk 3"));
        setVisible(true);
    }
}
