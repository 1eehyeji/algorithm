package baekjoon.dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// LCS(Longest Common Subsequence, 최장 공통 부분 수열)
public class B9251 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String s1 = br.readLine().trim();
		String s2 = br.readLine().trim();

		int[][] dp = new int[s1.length() + 1][s2.length() + 1];	// 두 문자열의 길이가 서로 다른 경우도 있음

		for (int i = 1; i <= s1.length(); ++i) {
			for (int j = 1; j <= s2.length(); ++j) {
				if (s1.charAt(i - 1) != s2.charAt(j - 1)) {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				} else {
					dp[i][j] = dp[i - 1][j - 1] + 1;
				}
			}
		}

		System.out.println(dp[s1.length()][s2.length()]);
	}
}
