package runner;

import db.Db;
import gui.GameMenuFrame;

import java.awt.*;

/**
 * Created by Jan Kakol on 2015-06-11.
 */
public class GameGUIRunner {

    private static final String DB = "db.object";

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                Db.initDb(DB);
                new GameMenuFrame();
            }
        });
    }
}
