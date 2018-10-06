package baekjoon.IO;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B11021 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int count = Integer.parseInt(br.readLine());

        for(int i = 0; i < count; ++i){
            String[] s = br.readLine().split(" ");
            int a = Integer.parseInt(s[0]);
            int b = Integer.parseInt(s[1]);
            System.out.println("Case #" + (i+1) +": " + (a+b));
        }

        br.close();
    }
}
