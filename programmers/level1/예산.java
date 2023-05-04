package programmers.level1;

import java.util.Arrays;

public class 예산 {
	private int solution(int[] d, int budget) {
		Arrays.sort(d);

		int sum = 0;
		int count = 0;
		for (int i = 0; i < d.length; ++i) {
			sum += d[i];

			if (sum <= budget) {
				++count;
			}
		}

		return count;
	}
}
