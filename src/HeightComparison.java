
import java.util.Scanner;

public class HeightComparison {
    Scanner scanner = new Scanner(System.in);

    public void compareHeight() {
        double tallestHeight = Double.MIN_VALUE;
        int tallestPerson = -1;

        for (int i = 0; i < 3; i++) {
            System.out.print("Enter height of person " + (i + 1) + ": ");
            double height = scanner.nextDouble();

            if (height > tallestHeight) {
                tallestHeight = height;
                tallestPerson = i + 1;
            }
        }

        if (tallestPerson == -1) {
            System.out.println("Invalid input.");
        } else {
            System.out.println("Person " + tallestPerson + " is the tallest.");
        }
    }
}
