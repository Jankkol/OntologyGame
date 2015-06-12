package helper;

import domain.Match;
import domain.User;

import java.util.Scanner;

/**
 * Created by Jan Kakol on 2015-05-28.
 */
public class InitGameHelper {

    public static Match createMatch(String userName, String questionCount) {
        User player = createPlayer(userName);
        System.out.println("Nice to meet you " + player.getName() + "");
        int numberOfQuestion = Integer.parseInt(questionCount);
        return new Match(player, QuestionHelper.getRandomQuestions(numberOfQuestion));
    }

    private static User createPlayer(String name) {
        return new User(name);
    }
}
