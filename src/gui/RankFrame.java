package gui;

import helper.GameHelper;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Jan Kakol on 2015-06-13.
 */
public class RankFrame extends AbstractFrame {

    public RankFrame(){
        super();
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);

        String allAnswer = GameHelper.getRank();

        JTextArea  result = new JTextArea (allAnswer);
        result.setEditable(false);
        JScrollPane scroll = new JScrollPane(result);
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        add(scroll);
    }
}
