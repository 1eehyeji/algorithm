package programmers.level2;

public class 피보나치수 {
	public int solution(int n) {
		long[] fibonacci = new long[n + 1];

		fibonacci[0] = 0;
		fibonacci[1] = 1;

		for (int i = 2; i <= n; ++i) {
			fibonacci[i] = (fibonacci[i - 1] + fibonacci[i - 2]) % 1234567;
		}

		return (int)(fibonacci[n]);
	}
}
