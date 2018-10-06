package baekjoon.String;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B10808 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        int[] apb = new int[26];

        for(int i = 0; i < s.length(); ++i){
            int idx = s.charAt(i) - 97;
            apb[idx] += 1;
        }

        for(int i : apb){
            System.out.print(i + " ");
        }
    }
}
