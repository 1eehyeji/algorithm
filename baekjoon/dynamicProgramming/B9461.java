package baekjoon.dynamicProgramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B9461 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        long[] p = new long[101];
        p[1] = p[2] = p[3] = 1;
        p[4] = p[5] = 2;

        for (int i = 6; i < 101; ++i)
            p[i] = p[i-1] + p[i-5];

        for(int j = 0; j < t; ++j){
            int n = Integer.parseInt(br.readLine());
            System.out.println(p[n]);
        }
    }
}
