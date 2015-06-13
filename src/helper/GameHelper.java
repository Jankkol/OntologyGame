package helper;

import db.Db;
import db.Rank;
import domain.Match;
import domain.Question;
import domain.User;
import dto.SmartFindDTO;

import java.util.*;

/**
 * Created by Jan Kakol on 2015-05-28.
 */
public class GameHelper {

    public static void checkAnswerAndAddScore(Match match, Question question, String answer) {
        Question questionFromDB = Db.getByDescription(question.getDescription());
        HashMap<String, Integer> answers = questionFromDB.getAnswers();

        ScoreCalculator.resolveScore(match, question, answer, answers);
    }

    public static void addAnswerToHistory(Question question, String answer) {
        Question questionFromDB = Db.getByDescription(question.getDescription());
        Integer value = questionFromDB.getAnswers().get(answer);
        if (value != null) {
            value = value + 1;
            questionFromDB.getAnswers().put(answer, value);
            Db.saveQuestion(questionFromDB);
        } else {
            questionFromDB.getAnswers().put(answer, 1);
            Db.saveQuestion(questionFromDB);
        }
    }

    public static String showAllAnswer() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Question question : Db.questionList) {
            stringBuilder.append(question.getDescription()).append(" ").append("\n\n");
            for (Map.Entry<String, Integer> entry : question.getAnswers().entrySet()) {
                stringBuilder.append(entry.getKey()).append(" :  ").append(entry.getValue()).append("\n");
            }
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public static int endGame(Match match) {
        int sum = 0;
        for (Map.Entry<Question, Integer> entry : match.getQuestions().entrySet()) {
            sum = sum + entry.getValue();
        }
        match.getUser().setScore(sum);
        return sum;
    }


    public static SmartFindDTO smartFind(String searchWord) {
        SmartFindDTO smartFindDTO = null;
        List<SmartFindDTO> smartFindDTOList = new ArrayList<SmartFindDTO>();
        for (Question question : Db.questionList) {
            for (Map.Entry answer : question.getAnswers().entrySet()) {
                if (answer.getKey().equals(searchWord)) {
                    smartFindDTO = new SmartFindDTO();
                    smartFindDTO.setImage(question.getImage());
                    smartFindDTO.setAnswer(searchWord);
                    smartFindDTO.setCount((Integer) answer.getValue());
                    smartFindDTO.setTypeOf(resolveType(question));
                    smartFindDTOList.add(smartFindDTO);
                    break;
                }
            }
        }
        Collections.sort(smartFindDTOList);
        return smartFindDTOList.size() > 0 ? smartFindDTOList.get(0) : null;
    }

    private static String resolveType(Question question) {
        String type = null;
        int value = 0;
        for (Map.Entry answer : question.getAnswers().entrySet()) {
            if ((Integer) answer.getValue() > value) {
                value = (Integer) answer.getValue();
                type = (String) answer.getKey();
            }
        }

        return type;
    }

    public static void saveUserScore(Match match) {
        Rank.userList.add(match.getUser());
    }

    public static String getRank() {
        StringBuilder stringBuilder = new StringBuilder();
        List<User> userList = Rank.userList;
        Collections.sort(userList);
        int i = 1;
        for (User user : userList) {
            stringBuilder.append(i).append(".  ").append(user.getName()).append(" : ").append(user.getScore()).append("\n");
            i++;
        }
        return stringBuilder.toString();
    }
}
