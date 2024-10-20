package exercise2;

public class FullTimeGameTester extends GameTester {

    public FullTimeGameTester(String name) {
        super(name, true); // Full-time status is true
    }

    @Override
    protected int getSalary(int hours) {
        // Full-time testers get $3000 base + $5 per additional hour
        return 3000 + (5 * hours);
    }
}
