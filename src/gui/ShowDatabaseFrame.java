package gui;

import helper.GameHelper;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Jan Kakol on 2015-06-11.
 */
public class ShowDatabaseFrame extends AbstractFrame {

    public ShowDatabaseFrame() throws HeadlessException {
        super();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
        String allAnswer = GameHelper.showAllAnswer();

        JTextArea  result = new JTextArea (allAnswer);
        add(result);
    }
}
