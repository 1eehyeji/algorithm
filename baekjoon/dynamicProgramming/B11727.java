package baekjoon.dynamicProgramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B11727 {
    static int solution(int n, int[] dp){
        if(n == 0 || n == 1) return 1;
        if(dp[n] > 0) return dp[n];
        dp[n] = (solution(n-1, dp) + solution(n-2, dp) + solution(n-2, dp)) % 10007;
        return dp[n];
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[n+1];

        System.out.println(solution(n, dp));
    }
}
