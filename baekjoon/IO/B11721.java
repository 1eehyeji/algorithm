package baekjoon.IO;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B11721 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split("");
        br.close();

        for(int i = 0; i < s.length; ++i){
            if(i != 0 && (i % 10) == 0) System.out.println();
            System.out.print(s[i]);
        }
    }
}
