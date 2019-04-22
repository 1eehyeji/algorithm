package baekjoon.String;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B2577 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());

        int num = a * b * c;

        int[] arr = new int[10];
        while(num > 0){
            int d = num % 10;
            arr[d] += 1;
            num /= 10;
        }

        for(int i : arr)
            System.out.println(i);

        br.close();
    }
}
