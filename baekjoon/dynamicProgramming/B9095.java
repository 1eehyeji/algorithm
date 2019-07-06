package baekjoon.dynamicProgramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B9095 {
    static int solution(int n, int[] dp){
        if(n == 0 || n == 1) return 1;
        if(n == 2) return 2;
        if(dp[n] > 0) return dp[n];
        dp[n] = solution(n-1, dp) + solution(n-2, dp) + solution(n-3, dp);
        return dp[n];
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; ++i) {
            int m = Integer.parseInt(br.readLine());
            int[] dp = new int[m + 1];
            System.out.println(solution(m, dp));
        }

        br.close();
    }
}
