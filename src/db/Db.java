package db;

import domain.Question;
import helper.SerializationHelper;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
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

    public static void fillData() {
        questionList = new ArrayList<Question>();
        questionList.add(new Question("kot", "content/kot.jpg", 1));
        questionList.add(new Question("pies", "content/pies.jpg", 1));
        questionList.add(new Question("dom", "content/dom.jpg", 2));
        questionList.add(new Question("java", "content/java.jpg", 3));
        questionList.add(new Question("ronaldo", "content/1.jpg", 3));
        questionList.add(new Question("most", "content/2.jpg", 3));
        questionList.add(new Question("stunt", "content/3.jpg", 3));
        questionList.add(new Question("pistolet", "content/4.jpg", 1));
        questionList.add(new Question("zima", "content/5.jpg", 2));
        questionList.add(new Question("motorowka", "content/6.jpg", 1));
        questionList.add(new Question("telefony", "content/7.jpg", 2));
        questionList.add(new Question("windows", "content/8.jpg", 1));
        questionList.add(new Question("boisko", "content/9.jpg", 1));
        questionList.add(new Question("motocykl", "content/10.jpg", 1));
        questionList.add(new Question("samolocik", "content/11.jpg", 2));
        questionList.add(new Question("lod", "content/12.jpg", 1));
        questionList.add(new Question("google", "content/13.jpg", 3));
        questionList.add(new Question("piasek", "content/14.jpg", 1));
        questionList.add(new Question("malpa", "content/15.jpg", 1));
        questionList.add(new Question("fajerwerki", "content/16.jpg", 1));
        questionList.add(new Question("cytryna", "content/17.jpg", 1));
        questionList.add(new Question("samolot", "content/18.jpg", 1));
        questionList.add(new Question("papieros", "content/19.jpg", 1));
        questionList.add(new Question("auto", "content/20.jpg", 2));
        questionList.add(new Question("chleb", "content/21.jpg", 1));
        questionList.add(new Question("miasto", "content/22.jpg", 3));
        questionList.add(new Question("komputer", "content/23.jpg", 1));
        questionList.add(new Question("kot2", "content/24.jpg", 1));
        questionList.add(new Question("slonecznik", "content/25.jpg", 2));
        questionList.add(new Question("plaza", "content/27.jpg", 3));
        questionList.add(new Question("ulica", "content/28.jpg", 3));
        questionList.add(new Question("smartfony", "content/29.jpg", 1));
        questionList.add(new Question("web", "content/30.jpg", 3));
        questionList.add(new Question("tygrys", "content/31.jpg", 1));
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

    public static HashMap<Question, Integer> testQuestion() {
        HashMap<Question, Integer> questionList = new HashMap<Question, Integer>();
        questionList.put(new Question("boisko", "content/9.jpg", 1), 0);
        questionList.put(new Question("papieros", "content/19.jpg", 1), 0);
        questionList.put(new Question("miasto", "content/22.jpg", 3), 0);
        questionList.put(new Question("web", "content/30.jpg", 3), 0);
        questionList.put(new Question("windows", "content/8.jpg", 1), 0);
        questionList.put(new Question("kot", "content/kot.jpg", 1), 0);
        return questionList;
    }
}
