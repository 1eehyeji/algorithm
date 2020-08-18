package baekjoon.dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B2565 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[][] cords = new int[N][2];
		int[] dp = new int[N];

		String[] s;
		for (int i = 0; i < N; ++i) {
			s = (br.readLine()).split(" ");
			cords[i][0] = Integer.parseInt(s[0]);
			cords[i][1] = Integer.parseInt(s[1]);
		}

		Arrays.sort(cords, (int[] o1, int[] o2) -> {
			return o1[0] - o2[0];
		});

		dp[0] = 1;
		int max = 0;
		for (int i = 1; i < N; ++i) {
			dp[i] = 1;
			for (int j = 0; j < i; ++j) {
				if (cords[j][1] < cords[i][1]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
			max = Math.max(max, dp[i]);
		}

		System.out.println(N - max);
	}
}
