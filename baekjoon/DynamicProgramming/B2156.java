package baekjoon.DynamicProgramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B2156 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] p = new int[n+1];

        for(int i = 1; i <= n; ++i){
            p[i] = Integer.parseInt(br.readLine());
        }
        br.close();

        long[] d = new long[n+1];

        d[1] = p[1];
        if(n > 1)
            d[2] = p[1] + p[2];
        for(int i = 3; i <= n; ++i){
            d[i] = d[i-1];
            if(d[i] < d[i-2] + p[i]){
                d[i] = d[i-2] + p[i];
            }
            if(d[i] < d[i-3] + p[i] + p[i-1]){
                d[i] = d[i-3] + p[i] + p[i-1];
            }
        }

        System.out.println(d[n]);
    }
}
