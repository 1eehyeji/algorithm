package baekjoon.math;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B1373 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        int n = s.length();

        if(n % 3 == 1) System.out.print(s.charAt(0));
        else if(n % 3 == 2) System.out.print((s.charAt(0) - '0') * 2 + (s.charAt(1) - '0'));
        for(int i = n%3; i < n; i += 3){
            System.out.print(((s.charAt(i)-'0') * 4) + ((s.charAt(i+1)-'0') * 2) + (s.charAt(i+2)-'0'));
        }

    }
}
