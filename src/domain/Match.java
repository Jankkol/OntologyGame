package domain;

import java.io.Serializable;
import java.util.HashMap;

/**
 * Created by Jan Kakol on 2015-05-28.
 */
public class Match implements Serializable {

    private User user;

    private HashMap<Question, Integer> questions;

    private int questionNumber = 1;

    public Match(User user, HashMap<Question, Integer> questions) {
        this.user = user;
        this.questions = questions;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public HashMap<Question, Integer> getQuestions() {
        return questions;
    }

    public int getQuestionNumber() {
        return questionNumber;
    }

    public void setQuestionNumber(int questionNumber) {
        this.questionNumber = questionNumber;
    }

    public void setQuestions(HashMap<Question, Integer> questions) {
        this.questions = questions;
    }
}
