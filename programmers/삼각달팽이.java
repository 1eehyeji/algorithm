package programmers;

import java.util.Arrays;

public class 삼각달팽이 {
	static int[] solution(int n) {
		int[][] t = new int[n][n];
		String[] directions = {"D", "R", "U"};

		int m = 0;
		int x = -1;
		int y = 0;
		int direction = 0;

		int length = (n * (n + 1)) / 2;
		int k = n;

		while (m < length) {
			for (int j = 0; j < k; ++j) {
				if (directions[direction].equals("D")) {
					++x;
				} else if (directions[direction].equals("R")) {
					++y;
				} else {
					--x;
					--y;
				}

				t[x][y] = ++m;
			}

			direction = (direction + 1) % 3;
			--k;
		}


		int[] answer = new int[length];
		int index = 0;
		for (int[] arr : t) {
			for (int j : arr) {
				if (j == 0)
					break;

				answer[index] = j;
				++index;
			}
		}

		return answer;
	}

	public static void main(String[] args) {
		int n = 5;

		System.out.println(Arrays.toString(solution(n)));
	}
}
