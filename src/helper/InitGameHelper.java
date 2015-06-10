package helper;

import domain.Match;
import domain.User;

import java.util.Scanner;

/**
 * Created by Jan Kakol on 2015-05-28.
 */
public class InitGameHelper {

    public static Match createMatch(Scanner in) {
        introduceGame();
        User player = createPlayer(in);
        System.out.println("Nice to meet you " + player.getName() + "");
        int numberOfQuestion = chooseNumberOfQuestion(in);
        Match match = new Match(player, QuestionHelper.getRandomQuestions(numberOfQuestion));
        return match;
    }

    private static int chooseNumberOfQuestion(Scanner in) {
        System.out.println("How many question you have to answer?");
        return Integer.parseInt(in.next());

    }

    private static User createPlayer(Scanner in) {
        User user = new User(in.next());
        return user;
    }

    private static void introduceGame() {
        System.out.println("Hello in our ontology game ! Have fun");
        System.out.println("");
        System.out.println("Firstly please insert your name: ");
    }
}
