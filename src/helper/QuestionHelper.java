package helper;

import db.Db;
import domain.Question;

import java.util.HashMap;
import java.util.Random;

/**
 * Created by Jan Kakol on 2015-05-28.
 */
public class QuestionHelper {


    public static HashMap<Question, Integer> getRandomQuestions(int numberOfQuestion) {
        HashMap<Question, Integer> questions = new HashMap<Question, Integer>();
        for (int i = 0; i < numberOfQuestion; i++) {
            Random random = new Random();
            questions.put(Db.questionList.get(random.nextInt(Db.questionList.size())), 0);
        }
        return questions;
    }
}
