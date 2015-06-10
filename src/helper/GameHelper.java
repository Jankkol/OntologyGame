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
            System.out.println(numberOfQuestion + " : " + question.getSubscription());
            String answer = in.next();
            addAnswerToHistory(question, answer);
        }
        System.out.println("");
    }

    private static void addAnswerToHistory(Question question, String answer) {
        Question questionFromDB = Db.getByDescription(question.getSubscription());
        if (questionFromDB.getAnswers().get(answer) != null) {
            Integer integer = questionFromDB.getAnswers().get(answer);
            questionFromDB.getAnswers().put(answer, integer++);
        } else {
            questionFromDB.getAnswers().put(answer, 1);
        }
    }

    public static void showAllAnswer() {
        for (Question question : Db.questionList) {
            System.out.println(question.getSubscription() + " ");
            for (Map.Entry<String, Integer> entry : question.getAnswers().entrySet()) {
                System.out.println(entry.getKey() + " :  " + entry.getValue());
            }
        }
    }
}
