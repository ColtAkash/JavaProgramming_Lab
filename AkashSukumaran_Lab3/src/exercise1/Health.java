package exercise1;

public class Health extends Insurance {

    public Health() {
        super("Health");
    }

    @Override
    public void setInsuranceCost(double fee) {
        System.out.println("Set Insurance cost for health insurance.");
        monthlyCost = fee * 0.5;
    }

    @Override
    public void displayInfo() {
        System.out.println("\n======================================");
        System.out.println("Displaying information of Health Insurance.");
        System.out.println("Type of insurance: " + getTypeOfInsurance());
        System.out.println("Adjusted monthly cost: " + getMonthlyCost());
        System.out.println("======================================\n");
    }

}
