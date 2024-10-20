package exercise1;

public class Life extends Insurance {

    public Life() {
        super("Life");
    }

    @Override
    public void setInsuranceCost(double fee) {
        System.out.println("Set Insurance cost for life insurance.");
        monthlyCost = fee * 1.1;
    }

    @Override
    public void displayInfo() {
        System.out.println("\n+++++++++++++++++++++++++++++++++++++++");
        System.out.println("Displaying information of Life Insurance.");
        System.out.println("Type of insurance: " + getTypeOfInsurance());
        System.out.println("Adjusted monthly cost: " + getMonthlyCost());
        System.out.println("+++++++++++++++++++++++++++++++++++++++\n");
    }

}
