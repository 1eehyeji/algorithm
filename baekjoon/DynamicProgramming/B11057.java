package baekjoon.DynamicProgramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B11057 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        br. close();

        long[][] d = new long[n+1][10];

        for(int i = 0; i < 10; ++i){
            d[1][i] = 1;
        }

        for(int i = 2; i <= n; ++i){
            for(int j = 0; j < 10; ++j){
                for(int z = 0; z <= j; ++z){ // z는 n 자리에 위치하는 값과 같거나 작은 값
                    d[i][j] += d[i-1][z];
                    d[i][j] %= 10007;
                }
            }
        }

        long sum = 0;
        for(int i = 0; i < 10; ++i){
            sum += d[n][i];
        }
        System.out.println(sum % 10007);
    }
}
