package runner;

import gui.GameMenuFrame;

import java.awt.*;

/**
 * Created by Jan Kakol on 2015-06-11.
 */
public class GameGUIRunner {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new GameMenuFrame();
            }
        });
    }
}
