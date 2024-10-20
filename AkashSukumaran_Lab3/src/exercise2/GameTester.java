package exercise2;

public abstract class GameTester {

    protected String name;
    protected boolean fullTimeStatus;

    // Constructor for GameTester class
    protected GameTester(String name, boolean status) {
        this.name = name;
        this.fullTimeStatus = status;
    }

    // Abstract method to be implemented by subclasses
    protected abstract int getSalary(int hours);

    // Getter methods
    protected String getName() {
        return name;
    }

    protected boolean getStatus() {
        return fullTimeStatus;
    }
}
