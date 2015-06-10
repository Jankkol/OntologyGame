package domain;

import java.util.HashMap;

/**
 * Created by Jan Kakol on 2015-05-28.
 */
public class Question {

    private String subscription;

    private HashMap<String, Integer> answers = new HashMap<String, Integer>();

    private String image;

    private int difficultyFactor;

    public Question(String subscription, int difficultyFactor) {
        this.subscription = subscription;
        this.difficultyFactor = difficultyFactor;
    }

    public String getSubscription() {
        return subscription;
    }

    public void setSubscription(String subscription) {
        this.subscription = subscription;
    }

    public HashMap<String, Integer> getAnswers() {
        return answers;
    }

    public void setAnswers(HashMap<String, Integer> answers) {
        this.answers = answers;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getDifficultyFactor() {
        return difficultyFactor;
    }

    public void setDifficultyFactor(int difficultyFactor) {
        this.difficultyFactor = difficultyFactor;
    }
}
