package baekjoon.dynamicProgramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B1699 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        br.close();

        int[] d = new int[n+1];

        for(int i = 1; i <= n; ++i){
            d[i] = i; // 주어진 n값 만큼 1^2을 더하는 경우가 가장 큰 경우
            for(int j = 1; j*j <= i; ++j){
                if(d[i] > d[i-(j*j)] + 1)
                    d[i] = d[i-(j*j)] + 1;
            }
        }

        System.out.println(d[n]);
    }
}
