package baekjoon.math;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B1212 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();

        if(s.charAt(0) == '0') System.out.print(0);

        String[] arr = { "000", "001", "010", "011", "100", "101", "110", "111" };

        for(int i = 0; i < s.length(); ++i){
            int n = s.charAt(i) - '0';
            if(i == 0 && n < 4){
                if(n == 1) System.out.print("1");
                else if(n == 2) System.out.print("10");
                else if(n == 3) System.out.print("11");
            }
            else{
                System.out.print(arr[n]);
            }
        }
    }
}
