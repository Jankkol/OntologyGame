package gui;

import domain.Match;
import domain.Question;
import helper.GameHelper;
import helper.InitGameHelper;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

/**
 * Created by Jan Kakol on 2015-06-11.
 */
public class GameFrame extends AbstractFrame {

    public static Match match = null;

    public static int questionNo = 1;

    public GameFrame() {
        super();
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);

        final JTextField answer = new JTextField(5);
        final JButton next = new JButton("Next");
        final JButton startGame = new JButton("Start Game");
        final JButton finishGame = new JButton("Finish Game");
        final JPanel initGamePanel = new JPanel();
        final JTextField name = new JTextField(5);
        final JTextField questionCount = new JTextField(3);
        initGamePanel.add(new JLabel("Enter your Name: "));
        initGamePanel.add(name);
        initGamePanel.add(new JLabel("How many question you have to answer?"));
        initGamePanel.add(questionCount);

        add(initGamePanel);
        startGame.addActionListener(startGame(initGamePanel, startGame, next, name, questionCount, answer));
        add(startGame);

    }

    private ActionListener startGame(final JPanel initGamePanel, final JButton startGame, final JButton next, final JTextField name, final JTextField questionCount, final JTextField answer) {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                remove(initGamePanel);
                startGame.setVisible(false);
                add(answer);
                add(next);
                answer.setVisible(true);
                next.setVisible(true);
                match = InitGameHelper.createMatch(name.getText(), questionCount.getText());
                int i = 1;
                for (Question entry : match.getQuestions().keySet()) {
                    if(i == questionNo) {
                        add(new ImagePanel(entry.getImage()));
                        break;
                    }
                    i++;
                }
                repaint();
            }
        };
    }
}
