package baekjoon.math;

import java.util.Scanner;

public class B9613 {

    static int gcd(int a, int b){
        if(b == 0) return a;
        else return gcd(b, a%b);
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        int t = in.nextInt();

        for(int i = 0; i < t; ++i){
            int n = in.nextInt();
            int[] a = new int[n];
            for(int j = 0; j < n; ++j)
                a[j] = in.nextInt();
            long sum = 0;
            for(int j = 0; j < n; ++j)
                for(int z = j+1; z < n; ++z)
                    sum += gcd(a[j], a[z]);
            System.out.println(sum);
        }
    }
}
