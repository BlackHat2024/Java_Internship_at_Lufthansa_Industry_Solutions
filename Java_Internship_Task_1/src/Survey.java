import java.util.ArrayList;
import java.util.List;

public class Survey {

    private Integer id ;
    private  String title ;
    private String description;
    private String topic ;
    private List<Question> questions = new ArrayList<>() ;

    private  List<User> users = new ArrayList<>() ;

    public Survey() {
    }

    public Survey(Integer id, String title, String description, String topic) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.topic = topic;
    }

    public List<Question> addQuestion(Question question) {
        int index = questions.size();
        question.setId(index+1);
        questions.add(question) ;
        return questions;
    }

    public Question findQuestionById(Integer id){
        if(questions.size()<id){
            System.out.println("Question with Id "+ id +" does not exist" );
            return  null ;
        }
        else{
            Question question = questions.get(id-1);
            return  question;
        }

    }

    public Question removeQuestion(Integer id){
        if(questions.size()<id){
            System.out.println("Question with Id "+ id +" does not exist" );
            return  null ;
        }
        else{
            Question question = questions.get(id-1);
            questions.remove(id-1) ;
            return  question;
        }

    }

    public void addUsers(User user) {
        users.add(user);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }
}
