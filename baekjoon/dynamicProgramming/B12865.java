package baekjoon.dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B12865 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[][] bag = new int[N + 1][2];
		int[][] dp = new int[N + 1][K + 1];

		for (int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine());
			bag[i][0] = Integer.parseInt(st.nextToken());
			bag[i][1] = Integer.parseInt(st.nextToken());
		}

		for (int i = 1; i <= N; ++i) {
			for (int j = 1; j <= K; ++j) {
				dp[i][j] = dp[i - 1][j];

				if (j >= bag[i - 1][0]) {
					dp[i][j] = Math.max(dp[i - 1][j - bag[i - 1][0]] + bag[i - 1][1], dp[i][j]);
				}
			}
		}
		System.out.println(dp[N][K]);
	}
}

