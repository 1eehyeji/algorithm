package baekjoon.Math;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B10872 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int result = 1;
        for(int i = n; i > 0; --i){
            result *= i;
        }

        System.out.println(result);
    }
}
