package baekjoon.IO;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B2558 {
    public static  void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());

        br.close();

        System.out.print(a+b);
    }
}
