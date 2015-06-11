package db;

import domain.Question;
import helper.SerializationHelper;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jan Kakol on 2015-05-28.
 */
public class Db implements Serializable {

    public static List<Question> questionList;

    public static void initDb(String db) {
        try {
            List<Question> o = (List<Question>) SerializationHelper.deSerialize(db);
            if (o == null || o.size() == 0) {
                fillData();
            } else {
                questionList = o;
            }
        } catch (IOException e) {
            fillData();
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            fillData();
            e.printStackTrace();
        }

    }

    public static Question getByDescription(String description) {
        for (Question question : questionList) {
            if (question.getDescription().equals(description)) {
                return question;
            }
        }
        return null;
    }

    private static void fillData() {
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

    public static void saveDb(String db) {
        try {
            SerializationHelper.serialize(questionList, db);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void saveQuestion(Question questionFromDB) {
        for (Question question : questionList) {
            if (question.getDescription().equals(questionFromDB.getDescription())) {
                question.setAnswers(questionFromDB.getAnswers());
            }
        }
    }
}
