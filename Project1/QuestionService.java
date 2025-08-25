
import java.util.Scanner;

public class QuestionService {

    Question questions[] = new Question[5];
    String selection[] = new String[5];

    public QuestionService() {

        questions[0] = new Question(
                0,
                "What is the capital of India?",
                new String[]{"Mumbai", "Chennai", "Delhi", "Kolkata"},
                "Delhi"
        );

        questions[1] = new Question(
                1,
                "Who is the father of Java Programming Language?",
                new String[]{"Dennis Ritchie", "James Gosling", "Bjarne Stroustrup", "Guido van Rossum"},
                "James Gosling"
        );

        questions[2] = new Question(
                2,
                "Which data structure uses LIFO?",
                new String[]{"Queue", "Array", "Stack", "LinkedList"},
                "Stack"
        );

        questions[3] = new Question(
                3,
                "Which company developed the React library?",
                new String[]{"Google", "Microsoft", "Facebook", "Amazon"},
                "Facebook"
        );

        questions[4] = new Question(
                4,
                "What is the full form of HTML?",
                new String[]{"HyperText Machine Language", "HighText Markup Language", "HyperText Markup Language", "HyperTool Multi Language"},
                "HyperText Markup Language"
        );

        System.out.println("\n Questions Are Ready ! You Can Start The Quiz Now \n");

    }

    public void playQuiz() {
        for (Question que : questions) {
            System.out.println();
            System.out.println();
            System.out.println("Question No :: " + que.getQuestionId() + 1);
            System.out.println(que.getQuestion());
            System.out.println("Options :: ");
            for (String opt : que.getOptions()) {
                System.out.println(opt);
            }

            System.out.print("Enter Youre Answere ==> ");
            Scanner sc = new Scanner(System.in);
            selection[que.getQuestionId()] = sc.nextLine();
            System.out.println();
            System.out.println();

        }
    }

    public void showScore() {
        int Score = 0;
        for (Question que : questions) {

            if (que.getAnswere().equals(selection[que.getQuestionId()])) {
                Score++;
            }
        }
        System.out.print("Youre Score Is ==> " + Score);
        System.out.println("\nThank You !\n");
    }
}
