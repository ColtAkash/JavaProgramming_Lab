package exercise3;

public class PersonalMortgage extends Mortgage {

    public PersonalMortgage(int mortgageNumber, String customerName, double amount, int term) {
        // Set interest rate 2% over the prime rate
        super(mortgageNumber, customerName, amount, PRIME_RATE + 0.02, term);
    }
}
