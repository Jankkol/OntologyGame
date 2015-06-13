package dto;

/**
 * Created by Jan Kakol on 2015-06-13.
 */
public class FindDTO {

    private String answer;

    private int count;

    private SmartFindDTO smartFindDTO = new SmartFindDTO();

    public SmartFindDTO getSmartFindDTO() {
        return smartFindDTO;
    }

    public void setSmartFindDTO(SmartFindDTO smartFindDTO) {
        this.smartFindDTO = smartFindDTO;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
