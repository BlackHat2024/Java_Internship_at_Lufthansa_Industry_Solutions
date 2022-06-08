import java.util.*;

public class Program {


    public static User findUserByEmail(List<User>  users , String email){
        for(User u : users){
            if(u.getEmail().equals(email)) return  u ;
        }
        return null ;
    }


    public static String findMostRepeatedAnswer(Map<String, Integer> questionNrAnswers){
        String answer = (String) questionNrAnswers.keySet().toArray()[0];
        Integer repetation = questionNrAnswers.get(answer);
        for (String key : questionNrAnswers.keySet()){

            Integer current = questionNrAnswers.get(key);
            if(current>repetation){
                answer = key ;
            }
        }
        return answer ;
    }

    public static void main(String[] args) {
        System.out.println("Welcome to survey system");
        Map<Integer, Survey> db = SurveyDatabase.getDB() ;
        Map<Integer, User> users = new HashMap<>() ;
        Scanner input = new Scanner(System.in) ;

        //Complete the survey
        while (true){
            System.out.println("Press 1 to register new user");
            System.out.println("Press 2 to enter as a user");
            System.out.println("Press 3 to exit");
            int choice = input.nextInt();
            while(choice<1 || choice>3 ){
                System.out.println("Wrong input (Type 1-3)");
                choice = input.nextInt() ;
            }
            if(choice==3) break;

            else if (choice==1) {
                //Map<Integer, Map<Integer, String>> surveyRecord= new HashMap<>();
                input.nextLine() ;
                System.out.print("Enter name: ");
                String name = input.nextLine();

                System.out.print("Enter surname: ");
                String surname = input.nextLine();
                System.out.print("Enter email: ");
                String email = input.nextLine();
                User u = findUserByEmail(new ArrayList<>(users.values()), email);

                while( u!=null){
                    System.out.println("User with " + email + " already exist");
                    System.out.print("Enter email again: ");
                    email = input.nextLine() ;
                    u = findUserByEmail((new ArrayList<>(users.values())),email) ;
                }
                u = new User(users.size()+1, name , surname, email ) ;
                users.put(u.getId() ,u) ;

                System.out.println("Press 1 to chose a survey");
                System.out.println("Press 2 to exit");
                choice = input.nextInt() ;

                while(choice<1 || choice>2 ){
                    System.out.println("Wrong input (Type 1-2)");
                    choice = input.nextInt() ;
                }

                if(choice==2) {
                    System.out.println();
                    System.out.println("-----------------------------------------------");
                    System.out.println();
                    continue;}
                else{
                    Map<Integer , String> ansRecord= new HashMap<>() ;
                    System.out.println("Survey List: ");
                    for( Integer id : db.keySet()){
                        System.out.println(String.format("%d %s" ,id ,db.get(id).getTopic()));
                    }
                    System.out.print("Chose survey: ");
                    Integer id  = input.nextInt();
                    Survey survey = db.get(id) ;

                    while(survey==null){
                        System.out.print("Wrong input! Chose survey: ");
                        id  = input.nextInt();
                        survey = db.get(id) ;
                    }

                    input.nextLine() ;
                    for (Question question : survey.getQuestions()){
                        Map<Integer, String> answers = question.getAnswer() ;
                        System.out.println(question.getQuestion());
                        for (Integer ansId : answers.keySet()){
                            System.out.println(String.format("%d %s", ansId , answers.get(ansId)));
                        }
                        System.out.print("Chose answer: ");
                        Integer ans = input.nextInt();
                        while(answers.get(ans)==null){
                            System.out.print("Wrong input. Chose answer: ");
                            ans = input.nextInt();
                        }
                        ansRecord.put(question.getId(), answers.get(ans)) ;
                    }

                    //surveyRecord.put(survey.getId(), ansRecord);
                    u.addSurvey(survey.getId(), ansRecord);
                    users.put(u.getId(), u);
                    survey.addUsers(u);
                    System.out.println();
                    System.out.println("-----------------------------------------------");
                    System.out.println();

                }


            }
            else{

                if(users.keySet().size()==0){
                    System.out.println("There is no user registered yet");
                    System.out.println("-----------------------------------------------");
                    System.out.println();
                    continue;
                }

                input.nextLine();
                System.out.print("Enter email: ");
                String email = input.nextLine();
                User u = findUserByEmail(new ArrayList<>(users.values()), email);

                while( u==null){
                    System.out.println("User with " + email + " does not exist");
                    System.out.print("Enter email again: ");
                    email = input.nextLine() ;
                    u = findUserByEmail((new ArrayList<>(users.values())),email) ;
                }

                System.out.println("Press 1 to chose a survey");
                System.out.println("Press 2 to exit");
                choice = input.nextInt() ;

                while(choice<1 || choice>2 ){
                    System.out.println("Wrong input (Type 1-2)");
                    choice = input.nextInt() ;
                }

                if(choice==2) {
                    System.out.println();
                    System.out.println("-----------------------------------------------");
                    System.out.println();
                    continue;}
                else {
                    Map<Integer, String> ansRecord = new HashMap<>();
                    System.out.println("Survey List: ");
                    for (Integer id : db.keySet()) {
                        System.out.println(String.format("%d %s", id, db.get(id).getTopic()));
                    }
                    System.out.print("Chose survey: ");
                    Integer id = input.nextInt();
                    Survey survey = db.get(id);

                    while(survey==null){
                        System.out.print("Wrong input! Chose survey: ");
                        id  = input.nextInt();
                        survey = db.get(id) ;
                    }

                    input.nextLine();

                    for (Question question : survey.getQuestions()) {
                        Map<Integer, String> answers = question.getAnswer();
                        System.out.println(question.getQuestion());
                        for (Integer ansId : answers.keySet()) {
                            System.out.println(String.format("%d %s", ansId, answers.get(ansId)));
                        }
                        System.out.print("Chose answer: ");
                        Integer ans = input.nextInt();
                        while (answers.get(ans) == null) {
                            System.out.print("Wrong input. Chose answer: ");
                            ans = input.nextInt();
                        }
                        ansRecord.put(question.getId(), answers.get(ans));
                        //System.out.println(answers.get(ans));
                    }

                    //surveyRecord.put(survey.getId(), ansRecord);
                    u.addSurvey(survey.getId(), ansRecord);
                    users.put(u.getId(), u);
                    survey.addUsers(u);
                    System.out.println();
                    System.out.println("-----------------------------------------------");
                    System.out.println();

                }
            }


        }

        //Survey records
        System.out.println();
        System.out.println("Surveys records");
        for (Survey survey : db.values()){

            System.out.println("Survey "+survey.getId());

            if(survey.getUsers().size()>0){
                Map<String, Integer> questionNrAnswers = new HashMap<>();
                for (User u : survey.getUsers()){
                    Map<Integer, String> answerRecord = u.getAnswerRecord(survey.getId()) ;

                    for (Question question : survey.getQuestions()){
                        String answer = answerRecord.get(question.getId()) ;
                        if(questionNrAnswers.get(answer)==null){
                            questionNrAnswers.put(answer, 1) ;
                        }
                        else{
                            Integer current = questionNrAnswers.get(answer) ;
                            questionNrAnswers.put(answer, current+1) ;
                        }

                    }
                }
                System.out.println("The most repeated answer is: " + findMostRepeatedAnswer(questionNrAnswers));

                System.out.println("-----------------------------------------------------------------------");
                System.out.println("Question Details");

                for (Question question : survey.getQuestions()){
                    questionNrAnswers = new HashMap<>();
                    System.out.println("Question " + question.getId());
                    for (User u : survey.getUsers()){
                        Map<Integer, String> answerRecord = u.getAnswerRecord(survey.getId()) ;

                        String answer = answerRecord.get(question.getId()) ;
                        if(questionNrAnswers.get(answer)==null){
                            questionNrAnswers.put(answer, 1) ;
                        }
                        else{
                            Integer current = questionNrAnswers.get(answer) ;
                            questionNrAnswers.put(answer, current+1) ;
                        }

                    }

                    for (String ans : question.getAnswer().values()){
                        System.out.print(String.format("%s -> %d; ", ans , questionNrAnswers.get(ans)==null?0:questionNrAnswers.get(ans)));
                    }
                    System.out.println();
                }
            }
            else{
                System.out.println("No user has taken this survey");
            }

            System.out.println("\n-----------------------------------------------------");

        }

        System.out.println("\n Find answers of a user for a given survey");

        for (Survey survey : db.values()){
            System.out.println(survey.getId()+ " " + survey.getTopic());
        }
        System.out.print("Chose a survey: ");
        Integer id = input.nextInt() ;
        Survey survey =  db.get(id) ;

        while(survey==null){
            System.out.print("Wrong input! Chose survey: ");
            id  = input.nextInt();
            survey = db.get(id) ;
        }

        if(survey.getUsers().size()>0){
            System.out.println("Users list");

            for(User u : survey.getUsers()){
                System.out.println(String.format("%d -> Email: %s ", u.getId(), u.getEmail()));
            }

            System.out.print("Chose a user: ");
            id  = input.nextInt();
            User chosedUser = users.get(id);

            while(chosedUser==null || chosedUser.getAnswerRecord(survey.getId()) == null){
                System.out.print("Wrong input! Chose user: ");
                id  = input.nextInt();
                chosedUser = users.get(id) ;
            }
            System.out.println(String.format("For survey with topic: %s and user with id %d", survey.getTopic(),chosedUser.getId()));

            Map<Integer, String> answerRecords = chosedUser.getAnswerRecord(survey.getId()) ;

            for (Question question : survey.getQuestions()){
                System.out.println(String.format("Question: %s --> Answer: %s", question.getQuestion(), answerRecords.get(question.getId())));
            }

        }else{
            System.out.println("No user has solved this survey");
        }



    }
}
