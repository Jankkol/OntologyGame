package helper;

import db.Db;
import domain.Match;
import domain.Question;

import java.util.*;

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
            checkAnswerAndAddScore(match, question, answer);
            addAnswerToHistory(question, answer);
        }
        System.out.println("");
    }

    private static void checkAnswerAndAddScore(Match match, Question question, String answer) {
        Question questionFromDB = Db.getByDescription(question.getDescription());
        HashMap<String, Integer> answers = questionFromDB.getAnswers();

        ScoreCalculator.resolveScore(match, question, answer, answers);
    }

    private static void addAnswerToHistory(Question question, String answer) {
        Question questionFromDB = Db.getByDescription(question.getDescription());
        Integer value = questionFromDB.getAnswers().get(answer);
        if (value != null) {
            value = value + 1;
            questionFromDB.getAnswers().put(answer, value);
            Db.saveQuestion(questionFromDB);
        } else {
            questionFromDB.getAnswers().put(answer, 1);
            Db.saveQuestion(questionFromDB);
        }
    }

    public static String showAllAnswer() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Question question : Db.questionList) {
            stringBuilder.append(question.getDescription()).append(" ");
            for (Map.Entry<String, Integer> entry : question.getAnswers().entrySet()) {
                stringBuilder.append(entry.getKey()).append(" :  ").append(entry.getValue()).append("\n");
            }
        }
        return stringBuilder.toString();
    }

    public static void endGame(Match match) {
        int sum = 0;
        for (Map.Entry<Question, Integer> entry : match.getQuestions().entrySet()) {
            sum = sum + entry.getValue();
        }
        System.out.println("Your score is : " + sum);
    }


}
