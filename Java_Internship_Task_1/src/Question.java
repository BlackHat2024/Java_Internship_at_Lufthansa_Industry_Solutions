import java.util.LinkedHashMap;
import java.util.Map;

public class Question {
    private Integer id ;
    private  String question ;
    private Map<Integer , String > answer = new LinkedHashMap<>() ;


    public Question() {
    }

    public Question(String question) {
        this.question = question;
        answer.put(1,"Agree" ) ;
        answer.put(2,"Slightly Agree" ) ;
        answer.put(3,"Slightly DisAgree" ) ;
        answer.put(4,"DisAgree" ) ;
        answer.put(5,"No answer" ) ;
    }

    public Question(Integer id, String question) {
        this.id = id;
        this.question = question;
        answer.put(1,"Agree" ) ;
        answer.put(2,"Slightly Agree" ) ;
        answer.put(3,"Slightly DisAgree" ) ;
        answer.put(4,"DisAgree" ) ;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public Map<Integer, String> getAnswer() {
        return answer;
    }

    public void setAnswer(Map<Integer, String> answer) {
        this.answer = answer;
    }
}
