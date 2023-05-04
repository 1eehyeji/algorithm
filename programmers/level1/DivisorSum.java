package programmers.level1;

public class DivisorSum {
	public static int solution(int n) {
		if (n == 1) {
			return 1;
		}

		int maxDivisor = 1;
		int minQuotient = n;

		int answer = 0;

		while (maxDivisor < minQuotient) {
			minQuotient = n / maxDivisor;
			if ((n % maxDivisor) == 0) {
				answer += (maxDivisor == minQuotient) ? maxDivisor : (maxDivisor + minQuotient);
			}
			++maxDivisor;
		}

		return answer;
	}

	public static void main(String[] args) {
		int n1 = 1;
		int n2 = 49;

		System.out.println(solution(n1));
		System.out.println(solution(n2));
	}
}
