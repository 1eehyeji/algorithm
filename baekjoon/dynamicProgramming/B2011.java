package baekjoon.dynamicProgramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B2011 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        int n = s.length();
        s = " " + s;

        int[] d = new int[n+1];

        d[0] = 1;

        for(int i = 1; i <= n; ++i){
            int x = s.charAt(i) - '0';
            if(1 <= x && x <= 9){
                d[i] += d[i-1];
                d[i] %= 1000000;
            }
            if(i == 1) continue;

            if(s.charAt(i-1) == '0') continue;

            x = (s.charAt(i-1) - '0') * 10 + (s.charAt(i) - '0');
            if(10 <= x && x <= 26){
                d[i] += d[i-2];
                d[i] %= 1000000;
            }
        }
        System.out.println(d[n]);
    }
}
