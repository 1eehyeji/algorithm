package programmers;

import java.util.Arrays;

public class HIndex {
	static int solution(int[] citations) {
		int n = citations.length;
		int max = 0;

		Arrays.sort(citations);

		for (int h = 0; h <= n; ++h) {		// h의 최댓값은 논문의 편수 n을 넘지 않음
			int count = 0;
			for (int j : citations) {
				if (h <= j) {				// h번 이상 인용된 논문의 개수를 셈
					++count;
				}
			}

			if (count >= h) {				// h번 이상 인용된 논문이 h편 이상
				max = Math.max(max, h);
			}
		}

		return max;
	}

	public static void main(String[] args) {
		int[] citations = {3, 0, 6, 1, 5};

		System.out.println(solution(citations)); // 3
	}
}
