package Exercise1;

import javax.swing.JOptionPane;
import java.util.Random;
import java.text.NumberFormat;

public class Test {
    //declare
    String[] questions = {"""
                            Which of the following Java program units defines a group of related objects?
                                   
                            A.Java method
                            B.Java default constructor
                            C.Java
                            D.Java Class
                            """,
            """
                            Which of the following tools support the software-development process,\s
                           including editors for writing and editing programs and debuggers for locating logic
                           errors—errors that cause programs to execute incorrectly?
                           
                           A.Java Virtual Machine (JVM)
                           B.Java Integrated Development Envronments (IDE)
                           C.Java Development Kit (JDK)
                           D.Java Application Programming Interfaces (API)
                           """,
            """
                           How many significant digits does a floating-point number have?
                           A.15
                           B.10
                           C.7
                           D.5
                           """,
            """
                            When a method that specifies a return type other than void is called, \s
                            what must the method do when it completes its task? and completes its task,
                            the method must return a result to its calling method.
                            
                            A.It must return one result only to the statement one line after the line from which it was called.
                            B.It must return more than just one result to its caller.
                            C.It must return a result exactly to the point from which it was called.
                            D.It must return one result to the statement immediately after the method body.
                            """,
            """
                            Which of the following Java program units defines a group of related objects?
                            
                             A.Java Class
                             B.Java method
                             C.Java
                             D.Java default constructor
                            """
    };
    String[] choices = {"A", "B", "C", "D"};
    String[] correctAnswer = {"D","B","C","C","A"};
    String[] userSelects = new String[correctAnswer.length];
    String userSelect;
    boolean check;
    int correctCount = 0;
    int wrongCount = 0;
    float correctRate;
    //methods
    public void simulateQuestion() {
        for (int i = 0; i <questions.length; i++) {
            //define user select
            userSelect = (String) JOptionPane.showInputDialog(null,
                    questions[i], "Test",
                    JOptionPane.QUESTION_MESSAGE, null,
                    choices, choices[0]);
            //collecting user input
            userSelects[i] = userSelect;
            //check answer
            checkAnswer(i);
            //generate message
            JOptionPane.showMessageDialog(null,
                    generateMessage(i),
                    "Message",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }
    public void checkAnswer(int i) {
        if (userSelects[i].equals(correctAnswer[i])){
            check = true;
            correctCount += 1;
        }
        else {
            check = false;
            wrongCount += 1;
        }
    }
    public String generateMessage(int i) {
        Random random = new Random();
        if (check) {
            switch(random.nextInt(4)) {
                case 1 -> { return "Excellent!"; }
                case 2 -> { return "Good!"; }
                case 3 -> { return "Keep up the good work!"; }
                default -> { return  "Nice work!"; }
            }
        }
        else {
            switch(random.nextInt(4)) {
                case 1 -> { return "No. Please try again!"; }
                case 2 -> { return "Wrong. Try once more!"; }
                case 3 -> { return "Don't give up!"; }
                default -> { return  "No. Keep Trying."; }
            }
        }
    }
    public void inputAnswer() {
        //show percentage
        NumberFormat showPercent = NumberFormat.getPercentInstance();
        simulateQuestion();
        correctRate = (float)correctCount/questions.length;//MUST process or it will be 0!
        String message = "Your correct count is: " + correctCount + "\n" +
                "Your wrong count is: " + wrongCount + "\n" +
                "Your correct rate is: " + showPercent.format(correctRate);//Double.parseDouble(String.valueOf(correctCount))/5*100
        JOptionPane.showMessageDialog(null, message);
    }
}