package gui;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Jan Kakol on 2015-06-11.
 */
public class AbstractFrame extends JFrame {

    public static final int WIDTH = 500;

    public static final int HEIGHT = 500;

    public AbstractFrame(){
        super("Hello World");
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(100,100);
        pack();
    }
}
