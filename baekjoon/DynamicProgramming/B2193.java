package baekjoon.DynamicProgramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B2193 {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        br.close();

        long[] d = new long[n+1];
        d[1] = 1;

        for(int i = 2; i <= n; ++i){
            if(i == 2) d[i] = 1;
            d[i] = d[i-1] + d[i-2];
        }
        System.out.println(d[n]);
    }
}
