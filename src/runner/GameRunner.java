package runner;

import db.Db;
import domain.Match;
import helper.GameHelper;
import helper.InitGameHelper;

import java.util.Scanner;

/**
 * Created by Jan Kakol on 2015-05-28.
 */
public class GameRunner {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Db.initDb();
        Match match = InitGameHelper.createMatch(in);
        GameHelper.startGame(match, in);
        GameHelper.showAllAnswer();
    }
}
