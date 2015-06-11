package domain;

import java.io.Serializable;
import java.util.HashMap;

/**
 * Created by Jan Kakol on 2015-05-28.
 */
public class Question implements Serializable {

    private String description;

    private HashMap<String, Integer> answers = new HashMap<String, Integer>();

    private String image;

    private int difficultyFactor;

    public Question(Question question){
        this.description = question.getDescription();
        this.answers = question.getAnswers();
        this.difficultyFactor = question.getDifficultyFactor();
        this.image = question.getImage();
    }

    public Question(String description, int difficultyFactor) {
        this.description = description;
        this.difficultyFactor = difficultyFactor;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
