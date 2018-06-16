package algorithm_class;

public class Fibonacci1 {
	static int count = 0;

	static int fibonacci(int n) {
		++count;
		System.out.println(count + " " + n);
		if( n == 1 || n == 2 ) return 1;
		return fibonacci(n - 1) + fibonacci(n - 2);
	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(fibonacci(7));
	}

}
