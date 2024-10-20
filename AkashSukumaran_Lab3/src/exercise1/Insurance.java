package exercise1;

public abstract class Insurance {

    private String typeOfInsurance;
    protected double monthlyCost;

    // constructor
    public Insurance(String type) {
        typeOfInsurance = type;
    }

    protected String getTypeOfInsurance() {
        return typeOfInsurance;
    }

    protected double getMonthlyCost() {
        return monthlyCost;
    }

    protected abstract void setInsuranceCost(double fee);
    protected abstract void displayInfo();

}
