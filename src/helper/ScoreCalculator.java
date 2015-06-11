package helper;

import domain.Match;
import domain.Question;

import java.util.*;

/**
 * Created by Jan Kakol on 2015-05-28.
 */
public class ScoreCalculator {
    public static void resolveScore(Match match, Question question, String answer, HashMap<String, Integer> answers) {
        Integer score = 0;
        Object value = answers.get(answer);
        if (value != null) {
            score = (Integer) value;
        }
        match.getQuestions().put(question, score * question.getDifficultyFactor());
    }
}
