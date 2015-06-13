package gui;

import db.Db;
import db.Rank;
import domain.Match;
import domain.Question;
import domain.User;
import helper.GameHelper;
import helper.InitGameHelper;
import runner.GameGUIRunner;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Jan Kakol on 2015-06-11.
 */
public class TestGameplayFrame extends AbstractFrame {

    public static Match match = null;

    public static ImagePanel imagePanel;


    public TestGameplayFrame() throws HeadlessException {
        super();
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);

        final JButton startGame = new JButton("Start Game");
        final JTextField answer = new JTextField(5);
        final JButton next = new JButton("Next");
        final JButton finishGame = new JButton("Finish Game");
        final JPanel initGamePanel = new JPanel();
        final JLabel result = new JLabel();

        add(initGamePanel);
        add(startGame);
        startGame.addActionListener(startGame(initGamePanel, startGame, next, answer));
        next.addActionListener(nextStep(finishGame, answer, next, result));
        finishGame.addActionListener(finishGame());

    }

    private ActionListener finishGame() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Db.saveDb(GameGUIRunner.DB);
                dispose();
            }
        };
    }

    private ActionListener nextStep(final JButton finishGame, final JTextField answer, final JButton next, final JLabel result) {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GameHelper.checkAnswerAndAddScore(match, match.getActualQuestion(), answer.getText());
                GameHelper.addAnswerToHistory(match.getActualQuestion(), answer.getText());
                remove(imagePanel);
                answer.setText("");
                match.setQuestionNumber(match.getQuestionNumber() + 1);
                boolean setImage = setImage();
                if (!setImage) {
                    int score = GameHelper.endGame(match);
                    result.setText("Your score is: " + score + ". Thank you for game " + match.getUser().getName());
                    add(finishGame);
                    add(result);
                    answer.setVisible(false);
                    next.setVisible(false);
                    finishGame.setVisible(true);
                }
                validate();
                repaint();
            }
        };
    }


    private ActionListener startGame(final JPanel initGamePanel, final JButton startGame, final JButton next, final JTextField answer) {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                match = new Match(new User("user"), Db.testQuestion());
                remove(initGamePanel);
                startGame.setVisible(false);
                add(answer);
                add(next);
                answer.setVisible(true);
                next.setVisible(true);
                setImage();
                repaint();
            }
        };
    }

    private boolean setImage() {
        int i = 1;
        boolean isImageSet = false;
        if (match.getQuestions().size() >= match.getQuestionNumber()) {
            for (Question entry : match.getQuestions().keySet()) {
                if (i == match.getQuestionNumber()) {
                    match.setActualQuestion(entry);
                    imagePanel = new ImagePanel(entry.getImage());
                    add(imagePanel);
                    isImageSet = true;
                    break;
                }
                i++;
            }
        }
        return isImageSet;
    }
}
