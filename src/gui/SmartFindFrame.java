package gui;

import helper.GameHelper;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Jan Kakol on 2015-06-11.
 */
public class SmartFindFrame extends AbstractFrame {

    private static ImagePanel imagePanel = null;

    public SmartFindFrame() throws HeadlessException {
        super();
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);

        final JTextField searchWord = new JTextField(5);
        final JButton searchButton = new JButton("Search");
        final JTextField name = new JTextField(5);
        final JTextField questionCount = new JTextField(3);

        searchButton.addActionListener(smartFind(searchWord));
    }

    private ActionListener smartFind(final JTextField searchWord) {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GameHelper.smartFind(searchWord.getText());
                if (imagePanel == null) {

                }
            }
        };
    }
}
