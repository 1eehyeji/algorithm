package programmers;

public class Fibonacci {
	
	static int[] a = new int[100];
	
	static int solution(int n) {
		if(a[n] != 0) return a[n];
		if(n == 1 || n == 2) a[n] = 1;
		else a[n] = solution(n-1) + solution(n-2);
		return a[n];
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solution(3));
		System.out.println(solution(5));
	}
}
