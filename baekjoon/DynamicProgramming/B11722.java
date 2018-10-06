package baekjoon.DynamicProgramming;

import java.util.Scanner;

public class B11722 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[] a = new int[n];

        in.nextLine();

        for(int i = 0; i < n; ++i)
            a[i] = in.nextInt();

        in.close();

        int[] d = new int[n];

        for(int i = n - 1; i >= 0; --i){
            d[i] = 1;
            for(int j = n - 1; j > i; --j){
                if(a[i] > a[j] && d[i] < d[j]+1){
                    d[i] = d[j] + 1;
                }
            }
        }

        int max = 1;
        for(int i = 0; i < n; ++i)
            if(max < d[i]) max = d[i];

        System.out.println(max);
    }

}
