package baekjoon.DynamicProgramming;

import java.util.Scanner;

// 합분해
public class B2225 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int k = in.nextInt();

        long[][] d = new long[k+1][n+1];

        d[0][0] = 1;

        for(int i = 1;  i <= k; ++i){
            for(int j = 0; j <= n; ++j){
                for(int z = 0; z <= j; ++z){
                    d[i][j] += d[i-1][j-z];
                    d[i][j] %= 1000000000;
                }
            }
        }

        System.out.println(d[k][n]);
    }
}
