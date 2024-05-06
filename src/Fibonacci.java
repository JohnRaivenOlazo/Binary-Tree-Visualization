
public class Fibonacci {
	public void fibonacci(int n) {
		int firstTerm = 1, secondTerm = 1;
		
		 for (int i = 0; i < n; i++) {
	            System.out.print(firstTerm + " ");
	            int temp = firstTerm;
	            firstTerm = secondTerm;
	            secondTerm = temp + secondTerm;
	        }
	}
}
