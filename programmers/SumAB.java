package programmers;

public class SumAB {

	static public long solution(long a, long b) {
		long length = (a * b) < 0 ? Math.abs(b - a) : Math.abs(Math.abs(b) - Math.abs(a));

		long sum = (a + b) * (length + 1) / 2;

		return sum;
	}

	public static void main(String[] args) {
		int a = 3;
		int b = 5;

		System.out.println(solution(a, b));
	}
}
