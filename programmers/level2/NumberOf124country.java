package programmers.level2;

public class NumberOf124country {
	static String solution(int n) {
		StringBuilder sb = new StringBuilder();

		while (n > 0) {
			int m = n % 3;
			n /= 3;

			if (m == 0) {
				m = 4;
				--n;
			}

			sb.insert(0, m);
		}

		return sb.toString();
	}

	public static void main(String[] args) {
		int n = 10;

		System.out.println(solution(n));
	}
}
