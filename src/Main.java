import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    	Scanner s = new Scanner(System.in);
    	
    	System.out.print("Enter your name: ");
    	String name = s.nextLine();
    	System.out.println("Hello " + name + "\n\n");
    	System.out.println("Tell me what you want to do. Here are your options:\n\n");
    	
    	System.out.println("[1] Determine if a year is a LEAP YEAR or NOT");
    	System.out.println("[2] Height Comparison of 3 person");
    	System.out.println("[3] Display a series");
    	System.out.println("[4] Display a diamond of asterisk");
    	
    	int options = s.nextInt();
        
        switch (options) {
            case 1:
                //leapYear();
                break;
            case 2:
                //heightComparison();
                break;
            case 3:
                //series();
                break;
            case 4:
                //diamond();
                break;
            default:
                System.out.println("Choice was not on the list !");
        }
    }
}
