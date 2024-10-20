package exercise3;

public class BusinessMortgage extends Mortgage {

    public BusinessMortgage(int mortgageNumber, String customerName, double amount, int term) {
        // Set interest rate 1% over the prime rate
        super(mortgageNumber, customerName, amount, PRIME_RATE + 0.01, term);
    }
}
