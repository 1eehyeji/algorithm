package programmers;

public class 예상대진표 {
	static int solution(int n, int a, int b) {
		int answer = 1;

		while (Math.max(a, b) % 2 != 0 || Math.abs(a - b) != 1) {
			a -= a / 2;
			b -= b / 2;
			n /= 2;
			++answer;
		}

		return answer;
	}

	public static void main(String[] args) {
		int n = 8;
		int a = 2;
		int b = 3;

		System.out.println(solution(n, a, b));
	}
}