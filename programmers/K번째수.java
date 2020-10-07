package programmers;

import java.util.Arrays;

public class K번째수 {
	static int[] solution(int[] array, int[][] commands) {
		int[] answer = new int[commands.length];

		for (int n = 0; n < commands.length; ++n) {
			int i = commands[n][0] - 1;
			int j = commands[n][1];
			int k = commands[n][2] - 1;

			int[] temp = Arrays.copyOfRange(array, i, j);
			Arrays.sort(temp);

			answer[n] = temp[k];
		}

		return answer;
	}

	public static void main(String[] args) {
		int[] array = {1, 5, 2, 6, 3, 7, 4};
		int[][] commands = {
				{2, 5, 3},
				{4, 4, 1},
				{1, 7, 3}
		};

		System.out.println(Arrays.toString(solution(array, commands)));
	}
}
