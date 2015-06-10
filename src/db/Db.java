package db;

import domain.Question;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jan Kakol on 2015-05-28.
 */
public class Db {

    public static List<Question> questionList;

    public static void initDb() {
        questionList = new ArrayList<Question>();
        questionList.add(new Question("To jest coś tam coś tam", 1));
        questionList.add(new Question("To jest coś tam coś coś", 3));
        questionList.add(new Question("blablabla", 3));
        questionList.add(new Question("test", 3));
        questionList.add(new Question("hahaha", 3));
        questionList.add(new Question("moze sie uda", 3));
        questionList.add(new Question("dupa", 3));
        questionList.add(new Question("ontologia", 3));
        questionList.add(new Question("the game", 3));
    }

    public static Question getByDescription(String description) {
        for (Question question : questionList) {
            if (question.getSubscription().equals(description)) {
                return question;
            }
        }
        return null;
    }
}
