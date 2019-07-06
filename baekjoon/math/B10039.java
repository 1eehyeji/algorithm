package baekjoon.math;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B10039 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] a = new int[5];
        for(int i = 0; i < 5; ++i){
            int n = Integer.parseInt(br.readLine());
            if(n < 40) n = 40;
            a[i] = n;
        }

        int sum = 0;
        for(int i : a)
            sum += i;

        System.out.println(sum / 5);

        br.close();
    }
}
