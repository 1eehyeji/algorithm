package baekjoon.String;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B10809 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();

        br.close();

        int[] apb = new int[26];

        for(int i = 0; i < apb.length; ++i){
            apb[i] = -1;
        }

        for(int j = 0; j < s.length(); ++j){
            int idx = s.charAt(j) - 97;
            if(apb[idx] == -1) apb[idx] = j;
        }

        for(int i : apb){
            System.out.print(i + " ");
        }
    }
}
