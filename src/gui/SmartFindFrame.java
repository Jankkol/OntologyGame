package gui;

import dto.SmartFindDTO;
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

    private static JLabel result = null;

    public SmartFindFrame() throws HeadlessException {
        super();
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);

        final JTextField searchWord = new JTextField(5);
        final JButton searchButton = new JButton("Search");

        add(searchWord);
        add(searchButton);
        searchButton.addActionListener(smartFind(searchWord));
    }

    private ActionListener smartFind(final JTextField searchWord) {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SmartFindDTO smartFindDTO = GameHelper.smartFind(searchWord.getText());
                if (smartFindDTO != null) {
                    removeOldPanel();
                    imagePanel = new ImagePanel(smartFindDTO.getImage());
                    result = new JLabel("I think, yours " + smartFindDTO.getAnswer() + " is type of : " + smartFindDTO.getTypeOf());
                    add(imagePanel);
                    add(result);
                } else {
                    removeOldPanel();
                    if (imagePanel != null) {
                        remove(imagePanel);
                    }
                    result = new JLabel("We have no information about : " + searchWord.getText());
                    add(result);
                }

                validate();
                repaint();
            }
        };
    }

    private void removeOldPanel() {
        if (imagePanel != null) {
            remove(imagePanel);
        }
        if (result != null) {
            remove(result);
        }
    }
}
