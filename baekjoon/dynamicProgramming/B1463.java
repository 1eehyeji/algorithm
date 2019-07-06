package baekjoon.dynamicProgramming;

import java.util.Scanner;

public class B1463 {

    static int solution(int n, int[] dp){
        if(n == 1) return 0;
        if(dp[n] > 0) return dp[n];
        dp[n] = solution(n-1, dp) + 1;
        if(n%2 == 0){
            int temp = solution(n/2, dp) + 1;
            if(dp[n] > temp) dp[n] = temp;
        }
        if(n%3 == 0){
            int temp = solution(n/3, dp) + 1;
            if(dp[n] > temp) dp[n] = temp;
        }
        return dp[n];
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[] dp = new int[n+1];

        /*
        dp[1] = 0;
        for(int i = 2; i < n; ++i){

            dp[i] = dp[i - 1] + 1;

            if((i % 3) == 0 && dp[i] > dp[i/3] + 1){
                dp[i] = dp[i/3] + 1;
            }

            if((i % 2) == 0 && dp[i] > dp[i/2] + 1){
                dp[i] = dp[i/2] + 1;
            }
        }

        System.out.println(dp[n]);
        */

        in.close();
        System.out.println(solution(n , dp));
    }
}
