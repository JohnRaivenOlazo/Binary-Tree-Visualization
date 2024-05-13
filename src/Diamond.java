import java.util.Scanner;

public class Diamond {
    public void printDiamond(Scanner s) {
       Scanner s1 = new Scanner(System.in);
	        	    System.out.print("Enter the value of n: ");
	        	    int n = s.nextInt();

	        	    for (int i = 1; i <= 2 * n - 1; i++) {
	        	      int spaces = Math.abs(n - i);
	        	      int stars = 2 * n - 1 - 2 * spaces;

	        	      // Print spaces in a single loop
	        	      for (int j = 0; j < spaces; j++) {
	        	        System.out.print("  ");
	        	      }

	        	      // Print stars using StringBuilder
	        	      StringBuilder starsBuilder = new StringBuilder();
	        	      for (int k = 0; k < stars; k++) {
	        	        starsBuilder.append("* ");
	        	      }
	        	      System.out.println(starsBuilder.toString());
	        	    }
        // System.out.print("Enter the value of n: ");
        // int n = scanner.nextInt();

        // // Upper half
        // for (int i = 1; i <= n; i++) {
        //     for (int j = 1; j <= n - i; j++) {
        //         System.out.print("  ");
        //     }
        //     for (int k = 1; k <= 2 * i - 1; k++) {
        //         System.out.print("* ");
        //     }
        //     System.out.println();
        // }

        // // Lower half
        // for (int i = n - 1; i >= 1; i--) {
        //     for (int j = 1; j <= n - i; j++) {
        //         System.out.print("  ");
        //     }
        //     for (int k = 1; k <= 2 * i - 1; k++) {
        //         System.out.print("* ");
        //     }
        //     System.out.println();
        // }
    }

