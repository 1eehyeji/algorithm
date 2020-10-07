package programmers;

public class 소수찾기 {
	static int solution(int n) {
		int count = 0;

		for (int i = 2; i <= n; ++i) {
			boolean check = true;
			for (int j = 2; j <= Math.sqrt(i); ++j) {
				if ((i % j) == 0) {
					check = false;
					break;
				}
			}

			count += check ? 1 : 0;
		}

		return count;
	}
}
