package Exercise3;

public class Overloading3 {

    // Method 1: Calculate the area of a square
    public static int area(int side) {
        return side * side;
    }

    // Method 2: Calculate the area of a rectangle
    public static int area(int length, int width) {
        return length * width;
    }

    // Method 3: Calculate the area of a circle
    public static double area(double radius) {
        return Math.PI * radius * radius;
    }
}
