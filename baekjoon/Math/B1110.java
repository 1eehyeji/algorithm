package baekjoon.Math;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B1110 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int count = 0;
        int a = n;
        int sum = 0;
        while(true){
            if(0 < count && a == n) break;
            ++count;
            if(a < 10){
                sum = a;
                sum = (a % 10)*10 + (sum%10);
            }
            else if(10 <= a){
                sum = (a / 10) + (a % 10);
                sum = (a % 10)*10 + (sum % 10);
            }
            a = sum;
        }

        System.out.println(count);
        br.close();
    }
}
