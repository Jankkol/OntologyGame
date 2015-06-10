package helper;

import db.Db;
import domain.Match;
import domain.Question;

import java.util.Map;
import java.util.Scanner;

/**
 * Created by Jan Kakol on 2015-05-28.
 */
public class GameHelper {


    public static void startGame(Match match, Scanner in) {
        System.out.println("So.. Let's Try ! ");
        int numberOfQuestion = 0;
        for (Question question : match.getQuestions().keySet()) {
            numberOfQuestion++;
            System.out.println(numberOfQuestion + " : " + question.getDescription());
            String answer = in.next();
            addAnswerToHistory(question, answer);
        }
        System.out.println("");
    }

    private static void addAnswerToHistory(Question question, String answer) {
        Question questionFromDB = Db.getByDescription(question.getDescription());
        Integer value = questionFromDB.getAnswers().get(answer);
        if (value != null) {
            value = value + 1;
            questionFromDB.getAnswers().put(answer, value);
        } else {
            questionFromDB.getAnswers().put(answer, 1);
        }
    }

    public static void showAllAnswer() {
        for (Question question : Db.questionList) {
            System.out.println(question.getDescription() + " ");
            for (Map.Entry<String, Integer> entry : question.getAnswers().entrySet()) {
                System.out.println(entry.getKey() + " :  " + entry.getValue());
            }
        }
    }
}
