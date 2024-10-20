package exercise2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        boolean finish = false;
        Scanner input = new Scanner(System.in);

        do {
            System.out.println("Add a new game tester.");
            // Input name
            System.out.print("Enter name of tester: ");
            String name = input.nextLine();

            // Input hours of work
            int hour = 0;
            try {
                System.out.print("How many hours did " + name + " work? ");
                hour = input.nextInt();
                input.nextLine(); // Consume the newline character

                // Input status: full-time / part-time
                System.out.print("Is " + name + " a full-time tester? (y/n): ");
                String isFullTime = input.nextLine();

                // Create GameTester object based on full-time or part-time
                GameTester gameTester;
                if (isFullTime.equalsIgnoreCase("y")) {
                    gameTester = new FullTimeGameTester(name);
                } else {
                    gameTester = new PartTimeGameTester(name);
                }

                // Display results
                System.out.println("\nCreated a new Game Tester, " + gameTester.getName() + ".");
                System.out.print(gameTester.getName() + " is a ");
                if (gameTester.getStatus()) {
                    System.out.print("full-time");
                } else {
                    System.out.print("part-time");
                }
                System.out.println(" tester,");
                System.out.println("whose salary is $" + gameTester.getSalary(hour) + ".\n");

                // Ask if the user wants to add another tester
                System.out.print("Add another tester? (y/n): ");
                String another = input.nextLine();
                if (!another.equalsIgnoreCase("y")) {
                    finish = true;
                }

            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please try again.");
                input.nextLine(); // Clear the input buffer
            }

        } while (!finish);

        System.out.println("End of program. Bye!");
    }
}
