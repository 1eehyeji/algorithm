package baekjoon.dynamicProgramming;

import java.util.Scanner;

public class B11055 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[] a = new int[n];

        in.nextLine();

        for(int i = 0; i < n; ++i)
            a[i] = in.nextInt();

        in.close();

        int[] d = new int[n];

        for(int i = 0; i < n; ++i){
            d[i] = a[i];
            for(int j = 0; j < i; ++j){
                if(a[i] > a[j] && d[i] < d[j]+a[i]){
                    d[i] = d[j] + a[i];
                }
            }
        }

        int max = 1;
        for(int i = 0; i < n; ++i)
            if(max < d[i]) max = d[i];

        System.out.println(max);
    }
}
