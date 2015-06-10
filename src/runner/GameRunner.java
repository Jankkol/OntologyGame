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

    private static final String DB = "db.object";

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Db.initDb(DB);
        System.out.println("Hello in quiz game !!!");

        while (true) {
            int option = Integer.parseInt(in.next());
            switch (option) {
                case 1:
                    Match match = InitGameHelper.createMatch(in);
                    GameHelper.startGame(match, in);
                    System.out.println("Thank you for game !");
                    break;
                case 2:
                    GameHelper.showAllAnswer();
                    break;
                case 3:
                    Db.saveDb(DB);
                    break;
                default:
                    System.out.println("Wrong case!");
                    break;
            }
        }
    }
}
