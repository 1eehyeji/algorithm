package baekjoon.DynamicProgramming;

import java.util.Scanner;

public class B11054 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[] a = new int[n];

        in.nextLine();

        for(int i = 0; i < n; ++i)
            a[i] = in.nextInt();

        in.close();

        int[] d1 = new int[n];
        int[] d2 = new int[n];

        for(int i = 0; i < n; ++i){
            d1[i] = 1;
            for(int j = 0; j < i; ++j){
                if(a[i] > a[j] && d1[i] < d1[j]+1){
                    d1[i] = d1[j] + 1;
                }
            }
        }

        for(int i = n - 1; i >= 0; --i){
            d2[i] = 1;
            for(int j = n - 1; j > i; --j){
                if(a[i] > a[j] && d2[i] < d2[j]+1){
                    d2[i] = d2[j] + 1;
                }
            }
        }

        int max = 1;
        for(int i = 0; i < n; ++i)
            if(max < (d1[i] + d2[i] - 1)) max = d1[i] + d2[i] - 1;

        System.out.println(max);
    }
}
