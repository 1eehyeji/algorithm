package baekjoon.dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1463_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        long[] dp = new long[N + 1];

        dp[0] = 0;
        dp[1] = 0;

        for (int i = 2; i <= N; ++i) {
            long m = Integer.MAX_VALUE;

            if (i % 3 == 0) {
                m = dp[i / 3];
            }
            if (i % 2 == 0) {
                m = Math.min(m, dp[i / 2]);
            }

            dp[i] = Math.min(m, dp[i - 1]) + 1;
        }

        System.out.println(dp[N]);
    }
}
