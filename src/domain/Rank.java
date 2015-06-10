package domain;

import java.io.Serializable;
import java.util.HashMap;

/**
 * Created by Jan Kakol on 2015-06-10.
 */
public class Rank implements Serializable {

    HashMap<User, Integer> ranking = new HashMap<User, Integer>();


    public HashMap<User, Integer> getRanking() {
        return ranking;
    }

    public void setRanking(HashMap<User, Integer> ranking) {
        this.ranking = ranking;
    }
}
