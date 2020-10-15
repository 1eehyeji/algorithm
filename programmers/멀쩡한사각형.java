package programmers;

public class 멀쩡한사각형 {
	static long solution(long w, long h) {
		return (w * h) - ((w + h) - gcd(w, h));
	}

	static long gcd(long a, long b) {
		long num1 = Math.max(a, b);
		long num2 = Math.min(a, b);

		while(num2 != 0) {
			long r = (num1 % num2);
			num1 = num2;
			num2 = r;
		}

		return num1;
	}

	public static void main(String[] args) {
		int w = 2;
		int h = 2;

		System.out.println(solution(w, h));
	}
}
