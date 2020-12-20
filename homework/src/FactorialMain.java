

public class FactorialMain {

	public static void main(String[] args) {
		for (int i = 1 ; i<= 10 ; i++) {
			System.out.print("Factorial of "+ i +": " );
			for(int j = 1 ; j<i ; j++) {
				System.out.print(j+"*");
			}
			System.out.println(i+ "="+factorial(i));
		}
	}
	private static long factorial(final int n) {
		long result = 1;
		for(int i =1 ;i<=n ; i ++) {
			result *= i;
		}
		return result;	
	}
}
