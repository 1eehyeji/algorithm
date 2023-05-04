package programmers.level2;

import java.util.Arrays;

// 최대공약수를 구해서 최소공배수를 구하는 방법으로도 구현할 수 있다.
public class N개의최소공배수 {
	static int solution1(int[] arr) {
		int answer = 0;

		Arrays.sort(arr);

		for (int i = arr[arr.length - 1]; ; ++i) {
			boolean flag = true;

			for (int value : arr) {
				if (i % value != 0) {
					flag = false;
					break;
				}
			}

			if (flag) {
				answer = i;
				break;
			}
		}

		return answer;
	}

	static int solution2(int[] arr) {
		int answer = arr[0];

		for (int i = 1; i < arr.length; ++i) {
			int gdc = gdc(answer, arr[i]);

			answer = gdc * (answer / gdc) * (arr[i] / gdc);
		}

		return answer;
	}

	private static int gdc(int a, int b) {
		int min = Math.min(a, b);
		int max = Math.max(a, b);

		return (max % min) == 0 ? min : gdc(min, max % min);
	}
}
