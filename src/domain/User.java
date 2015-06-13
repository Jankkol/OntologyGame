package domain;

import java.io.Serializable;

/**
 * Created by Jan Kakol on 2015-05-28.
 */
public class User implements Serializable, Comparable<User> {

    private String name;

    private int score;

    public User(String name) {
        this.name = name;
        this.score = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public int compareTo(User o) {
        return o.getScore() - this.getScore();
    }
}
