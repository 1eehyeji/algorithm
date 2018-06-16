package algorithm_class;

public class Fibonacci2 {
	static int[] a = new int[100]; //재귀호출 반복을 줄이기 위한 배열
	
	static int fibonacci(int n) {
		if(a[n] != 0) return a[n];
		if(n == 1 || n == 2) a[n] = 1;
		else a[n] = fibonacci(n - 1) + fibonacci(n - 2);
		return a[n];
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(fibonacci(7));
	}

}
