package programmers.level1;

public class 삼진법뒤집기 {
	static int solution(int n) {
		int ansewr = 0;
		StringBuilder sb = new StringBuilder();


		//StringBuilder sb = new StringBuilder(Integer.toString(n, 3)); // 3진수로 변환하여 문자열로 바꿔줌
		//sb.reverse();

		while (n != 0) {
			sb.append(n % 3);
			n /= 3;
		}

		int e = 0;
		for (int i = sb.length() - 1; i >= 0; --i) {
			int num = sb.charAt(i) - '0';

			if (num != 0) {
				num *= (int) Math.pow(3, e);
				ansewr += num;
			}

			++e;
		}

		return ansewr;
	}
}
