package baekjoon.String;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B2743 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        br.close();

        System.out.println(s.length());
    }
}
