package baekjoon.dynamicProgramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B10844 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        br.close();
        long[][] d = new long[n+1][10];

        for(int i = 1; i < 10; ++i){
            d[1][i] = 1;
        }
        for(int i = 2; i <= n; ++i){
            for(int j = 0; j < 10; ++j){
                if(j-1 >= 0) d[i][j] += d[i-1][j-1];
                if(j+1 < 10) d[i][j] += d[i-1][j+1];
                d[i][j] %= 1000000000;
            }
        }
        long  ans = 0;
        for(int i = 0; i < 10; ++i){
            ans += d[n][i];
        }
        System.out.println(ans % 1000000000); // 나누는 이유..??
    }
}
