package programmers;

public class SumAB {

	static public long solution(long a, long b) {
		long length = Math.abs((a * b) < 0 ? b - a : Math.abs(b) - Math.abs(a)) + 1;

		long sum = ((a + b) * length) / 2;

		return sum;
	}

	public static void main(String[] args) {
		int a = 3;
		int b = 5;

		System.out.println(solution(a, b));
	}
}
