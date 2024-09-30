package Exercise2;

import javax.swing.JOptionPane;
import java.util.Random;
import java.util.stream.IntStream;

class Lotto {
    // Array to hold 3 random integer values between 1 and 9
    private int[] lottoNumbers;

    // Constructor to randomly populate the array
    public Lotto() {
        Random rand = new Random();
        lottoNumbers = new int[3];
        for (int i = 0; i < lottoNumbers.length; i++) {
            lottoNumbers[i] = rand.nextInt(9) + 1;  // random number between 1 and 9
        }
    }

    // Method to return the array
    public int[] getLottoNumbers() {
        return lottoNumbers;
    }
}

public class MyLotto {

    public static void main(String[] args) {
        // Declare variables
        int userChoice = 0;
        boolean win = false;

        // Loop up to 5 times for user attempts
        for (int i = 0; i < 5; i++) {
            // Create a new Lotto object
            Lotto lotto = new Lotto();

            // Get the array from Lotto class
            int[] lottoNumbers = lotto.getLottoNumbers();

            // Sum the array using IntStream
            int arraySum = IntStream.of(lottoNumbers).sum();

            // Collect user input and convert to int
            userChoice = Integer.parseInt(JOptionPane.showInputDialog(null, "Try a number between 3 and 27"));

            // While input is not valid, prompt again
            while (userChoice < 3 || userChoice > 27) {
                JOptionPane.showMessageDialog(null, "Please enter a number between 3 - 27");
                userChoice = Integer.parseInt(JOptionPane.showInputDialog(null, "Try a number between 3 and 27"));
            }

            // Response for different conditions
            if (userChoice == arraySum) {
                win = true;
                String message = "You Win!\nThe Lucky Number is: " + arraySum;
                JOptionPane.showMessageDialog(null, message, "Lotto", JOptionPane.INFORMATION_MESSAGE);
                break;
            } else {
                String message = "Whoops! The lucky number was: " + arraySum;
                JOptionPane.showMessageDialog(null, message, "Lotto", JOptionPane.ERROR_MESSAGE);
            }
        }

        // If no win after 5 attempts, computer wins
        if (!win) {
            JOptionPane.showMessageDialog(null, "Computer Wins!", "Lotto", JOptionPane.WARNING_MESSAGE);
        }
    }
}
