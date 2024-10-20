package exercise3;

import java.text.DecimalFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ProcessMortgage {

    public static void main(String[] args) {
        DecimalFormat df = new DecimalFormat("#.##");

        // Create an array to store 3 mortgages
        Mortgage[] mortgages = new Mortgage[3];

        System.out.println("Current prime interest rate: " + df.format(MortgageConstants.PRIME_RATE * 100) + "%");
        Scanner input = new Scanner(System.in);

        // Input mortgages
        for (int i = 0; i < mortgages.length; i++) {
            boolean validInput;
            System.out.println("#########################################");
            System.out.println("Creating Mortgage #" + (i + 1));

            int mortgageType = 1;
            int mortgageNumber = 0;
            String customerName = "";
            double amount = 0;
            int term = 1;

            do {
                validInput = true;
                try {
                    // Input mortgage type
                    do {
                        System.out.print("Input mortgage type (1 = Business, 2 = Personal): ");
                        mortgageType = input.nextInt();
                        input.nextLine();
                    } while (!(mortgageType == 1 || mortgageType == 2));

                    // Input mortgage details
                    System.out.print("Input mortgage number: ");
                    mortgageNumber = input.nextInt();
                    input.nextLine();

                    System.out.print("Input customer name: ");
                    customerName = input.nextLine();

                    // Input mortgage amount and validate
                    boolean validAmount = false;
                    while (!validAmount) {
                        System.out.print("Input mortgage amount ($): ");
                        amount = input.nextDouble();
                        input.nextLine();
                        if (!Mortgage.validAmount(amount)) {
                            System.out.println("Mortgage amount exceeds $300,000.");
                        } else {
                            validAmount = true;
                        }
                    }

                    // Input mortgage term
                    System.out.print("Input mortgage term (years): ");
                    term = input.nextInt();
                    input.nextLine();
                } catch (InputMismatchException e) {
                    input.nextLine();
                    System.out.println("Invalid input, please try again.");
                    validInput = false;
                }
            } while (!validInput);

            // Create and store mortgage based on the type
            if (mortgageType == 1) {
                mortgages[i] = new BusinessMortgage(mortgageNumber, customerName, amount, term);
            } else {
                mortgages[i] = new PersonalMortgage(mortgageNumber, customerName, amount, term);
            }
        }

        // Display all mortgages
        for (Mortgage mortgage : mortgages) {
            mortgage.getMortgageInfo();
        }
    }
}
