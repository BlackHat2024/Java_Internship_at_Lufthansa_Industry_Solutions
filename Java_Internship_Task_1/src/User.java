import java.util.HashMap;
import java.util.Map;


class User {

    private  Integer id ;
    private  String name ;
    private  String surname ;
    private  String email ;

    Map<Integer, Map<Integer ,String>> surveyRecord = new HashMap<>() ;

    public User() {
    }

    public User(Integer id, String name, String surname, String email) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void addSurvey(Integer surveyId, Map<Integer , String> answerRecords){
        surveyRecord.put(surveyId, answerRecords) ;

    }

    public Map<Integer , String> getAnswerRecord(Integer surveyId){
        return surveyRecord.get(surveyId) ;
    }

    public User clone (){
        return new User(id, name, surname, email);
    }
}