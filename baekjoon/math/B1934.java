package baekjoon.math;

import java.util.Scanner;

public class B1934 {

    static int gcd(int a, int b){ //최대공약수를 구하는 재귀함수
        if(b == 0) return a;
        else return gcd(b, a%b);
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        int t = in.nextInt();

        for(int i = 0; i < t; ++i){
            int a = in.nextInt();
            int b = in.nextInt();
            int gcd = gcd(a ,b);
            int lcm = (a * b) / gcd; // 최소공배수를 구하는 공식
            System.out.println(lcm);
        }

    }
}
