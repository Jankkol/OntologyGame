package dto;

import java.util.Comparator;

/**
 * Created by Jan Kakol on 2015-06-13.
 */
public class SmartFindDTO implements Comparable<SmartFindDTO>{

    private String image;

    private int count;

    private String answer;

    private String typeOf;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTypeOf() {
        return typeOf;
    }

    public void setTypeOf(String typeOf) {
        this.typeOf = typeOf;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    @Override
    public int compareTo(SmartFindDTO o) {
        return this.getCount() - o.getCount();
    }
}
