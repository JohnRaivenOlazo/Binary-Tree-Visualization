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
                Diamond(s);
                break;
            default:
                System.out.println("Choice was not on the list !");
        }
    }
public static void Diamond(Scanner s) {
			Scanner scanner = new Scanner(System.in);
	        System.out.print("Enter the value of n: ");
	        int n = scanner.nextInt();
	        
	        // Upper half
	        for (int i = 1; i <= n; i++) {
	            for (int j = 1; j <= n - i; j++) {
	                System.out.print("  "); 
	            }
	            for (int k = 1; k <= 2 * i - 1; k++) {
	                System.out.print("* ");
	            }
	            System.out.println(); 
	        }
	        
	        // Lower half
	        for (int i = n - 1; i >= 1; i--) {
	            for (int j = 1; j <= n - i; j++) {
	                System.out.print("  "); 
	            }
	            for (int k = 1; k <= 2 * i - 1; k++) {
	                System.out.print("* ");
	            }
	            System.out.println();
	        }
			
	        // time complexity T(n) = O(n * (n - 1))  or O(n^2) quadratic time
	        // need to lower the time complexity huhu
	        
	        // space complexity is O(1), okie na okie
		}  
}
