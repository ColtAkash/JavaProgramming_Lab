package exercise3;

import java.lang.Math;
import java.text.DecimalFormat;

public abstract class Mortgage implements MortgageConstants {

    protected int mortgageNumber;
    protected String customerName;
    protected double amount;
    protected double interestRate;
    protected int term;

    public Mortgage(int mortgageNumber, String customerName, double amount, double interestRate, int term) {
        this.mortgageNumber = mortgageNumber;
        this.customerName = customerName;
        this.amount = (amount <= MAX_AMOUNT) ? amount : MAX_AMOUNT;  // Limit mortgage amount to $300,000
        this.interestRate = interestRate;
        this.term = adjustTerm(term);  // Adjust term if invalid
    }

    // Display mortgage info
    public void getMortgageInfo() {
        DecimalFormat df = new DecimalFormat("#.##");
        df.setGroupingUsed(true);
        df.setGroupingSize(3);

        System.out.println("############################################");
        System.out.println("Mortgage Number: " + mortgageNumber);
        System.out.println("Customer Name: " + customerName);
        System.out.println("Mortgage Amount: $" + df.format(amount));
        System.out.println("Interest Rate: " + df.format(interestRate * 100) + "%");
        System.out.println("Term: " + term + " years");
        System.out.println("Total Amount Owed: $" + df.format(amount * Math.pow((1 + interestRate), term)));
        System.out.println();
    }

    // Check if amount is valid
    public static boolean validAmount(double amount) {
        return amount <= MAX_AMOUNT;
    }

    // Adjust term to a valid value
    protected static int adjustTerm(int inputTerm) {
        if (inputTerm == SHORT_TERM || inputTerm == MEDIUM_TERM || inputTerm == LONG_TERM) {
            return inputTerm;
        } else {
            return SHORT_TERM;  // Default to short-term if invalid
        }
    }
}
