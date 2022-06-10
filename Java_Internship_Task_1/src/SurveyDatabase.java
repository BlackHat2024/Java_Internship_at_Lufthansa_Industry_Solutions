import java.util.*;

public class SurveyDatabase {



    public static Map<Integer, Survey> getDB (){
        Map<Integer, Survey> database= new LinkedHashMap<>() ;
        List<Question> questions = new ArrayList<>();
        List<Survey>surveys = new ArrayList<>();

        //Survey 1
        questions.add(new Question("q1")) ;
        questions.add(new Question("q2")) ;
        questions.add(new Question("q3")) ;
        questions.add(new Question("q4")) ;
        questions.add(new Question("q5")) ;
        Survey survey= new Survey(surveys.size()+1, "title1", "description1","topic1" ) ;
        for(Question q : questions){
            survey.addQuestion(q) ;
        }

        surveys.add(survey) ;

        //Survey 2
        questions =new ArrayList<>() ;
        questions.add(new Question("A1")) ;
        questions.add(new Question("A2")) ;
        questions.add(new Question("A3")) ;
        questions.add(new Question("A4")) ;
        questions.add(new Question("A5")) ;

        survey= new Survey(surveys.size()+1, "title2", "description2","topic2" ) ;

        for(Question q : questions){
            survey.addQuestion(q) ;
        }

        surveys.add(survey) ;
        //Survey 3
        questions =new ArrayList<>() ;
        questions.add(new Question("w1")) ;
        questions.add(new Question("w2")) ;
        questions.add(new Question("w3")) ;
        questions.add(new Question("w4")) ;
        questions.add(new Question("w5")) ;

        survey= new Survey(surveys.size()+1, "title3", "description3","topic3" ) ;

        for(Question q : questions){
            survey.addQuestion(q) ;
        }

        surveys.add(survey) ;

        for(Survey s : surveys){
            database.put(s.getId(), s) ;
        }
        return  database;
    }
}
