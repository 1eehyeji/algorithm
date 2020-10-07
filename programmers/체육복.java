package programmers;

import java.util.Arrays;

public class 체육복 {
	static int solution(int n, int[] lost, int[] reserve) {
		int answer = 0;

		int[] arr = new int[n + 2];
		Arrays.fill(arr, 1);

		for (int i : lost) {
			arr[i] = 0;
		}

		for (int i : reserve) {
			arr[i] += 1;
		}

		for (int i = 1; i < arr.length; ++i) {
			if (arr[i] > 1) {
				if (arr[i - 1] == 0) {
					arr[i - 1] += 1;
				} else if (arr[i + 1] == 0) {
					arr[i + 1] += 1;
				}
			}
		}

		for (int i = 1; i < arr.length - 1; ++i) {
			if (arr[i] >= 1) {
				++answer;
			}
		}

		return answer;
	}

	public static void main(String[] args) {
		int n = 3;
		int[] lost = {1, 2, 3};
		int[] reserve = {3};

		System.out.println(solution(n, lost, reserve));
	}
}
