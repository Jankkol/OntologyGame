package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Jan Kakol on 2015-06-11.
 */
public class GameMenuFrame extends AbstractFrame {

    public GameMenuFrame() {
        super();
        setLayout(new FlowLayout());
        JPanel jPanel = new ImagePanel();
        final JButton startGame = new JButton("Start Game");
        final JButton testGame = new JButton("Test Game");
        final JButton showResults = new JButton("Show DataBase Questions");
        final JButton smartFind = new JButton("Smart find image");
        final JButton rank = new JButton("Rank");
        startGame.addActionListener(openFrame(MenuType.START_GAME));
        testGame.addActionListener(openFrame(MenuType.TEST_GAMEPLAY));
        showResults.addActionListener(openFrame(MenuType.SHOW_DB));
        smartFind.addActionListener(openFrame(MenuType.SMART_FIND));
        rank.addActionListener(openFrame(MenuType.RANK));

        add(jPanel);
        add(startGame);
        add(testGame);
        add(showResults);
        add(rank);
        add(smartFind);
        setVisible(true);
    }

    private ActionListener openFrame(final MenuType type) {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch (type) {
                    case START_GAME:
                        new GameFrame();
                        break;
                    case TEST_GAMEPLAY:
                        new TestGameplayFrame();
                        break;
                    case SHOW_DB:
                        new ShowDatabaseFrame();
                        break;
                    case SMART_FIND:
                        new SmartFindFrame();
                        break;
                    case RANK:
                        new RankFrame();
                        break;
                    default:
                        break;
                }

            }
        };
    }
}
