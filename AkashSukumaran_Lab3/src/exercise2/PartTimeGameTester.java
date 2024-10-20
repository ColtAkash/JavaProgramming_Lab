package exercise2;

public class PartTimeGameTester extends GameTester {

    public PartTimeGameTester(String name) {
        super(name, false); // Part-time status is false
    }

    @Override
    protected int getSalary(int hours) {
        // Part-time testers get $20 per hour
        return hours * 20;
    }
}
