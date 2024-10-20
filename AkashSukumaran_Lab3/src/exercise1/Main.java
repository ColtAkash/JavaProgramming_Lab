package exercise1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        final int num = 4; // the number of new insurance policies we are creating
        Scanner scanner = new Scanner(System.in);
        Insurance[] insuranceList = new Insurance[num];

        // repeat accepting input for new insurance
        for (int i = 0; i < num; i++) {
            System.out.println("Creating new insurance...");
            Insurance insurance;
            double fee = 0;
            boolean validFeeInput;
            boolean validTypeInput;

            // repeat until both type and fee inputs are correct
            do {
                validTypeInput = false;
                validFeeInput = true;

                System.out.print("Enter type of insurance (Health or Life): ");
                String type = scanner.nextLine();

                // repeat input for fee until valid input is received
                do {
                    System.out.print("Enter monthly fee: ");
                    try {
                        fee = scanner.nextDouble();
                        validFeeInput = true;
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid fee input. Please enter a valid number for the fee.");
                        validFeeInput = false;
                        scanner.nextLine();  // clear the scanner buffer
                    }
                } while (!validFeeInput);

                scanner.nextLine(); // Consume the newline left after double input

                // Create appropriate insurance based on user input
                if (type.equalsIgnoreCase("Health")) {
                    insurance = new Health();
                    insuranceList[i] = insurance;
                    validTypeInput = true;
                } else if (type.equalsIgnoreCase("Life")) {
                    insurance = new Life();
                    insuranceList[i] = insurance;
                    validTypeInput = true;
                } else {
                    System.out.println("Invalid insurance type. Please enter 'Health' or 'Life'.");
                }

            } while (!validTypeInput);

            // Accessing method through superclass
            insuranceList[i].setInsuranceCost(fee);
            insuranceList[i].displayInfo();
        }

        System.out.println("End of program. Thank you!");
        scanner.close();
    }
}
