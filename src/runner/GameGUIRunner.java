package runner;

import db.Db;
import db.Rank;
import domain.User;
import gui.GameMenuFrame;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Jan Kakol on 2015-06-11.
 */
public class GameGUIRunner {

    public static final String DB = "db.object";

    public static final String RANK = "rank.object";

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                //saveDb();
                //saveRank();
                Db.initDb(DB);
                Rank.initRank(RANK);
                new GameMenuFrame();
            }
        });
    }

    public static void saveRank(){
        Rank.userList = new ArrayList<User>();
        Rank.saveRank(RANK);
    }

    public static void saveDb(){
        Db.fillData();
        Db.saveDb(DB);
    }
}
