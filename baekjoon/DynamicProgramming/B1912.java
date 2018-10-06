package baekjoon.DynamicProgramming;

import java.util.Scanner;

public class B1912 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[] a = new int[n];

        in.nextLine();

        for(int i = 0; i < n; ++i)
            a[i] = in.nextInt();

        in.close();

        int[] d = new int[n];
        d[0] = a[0];

        for(int i = 1; i < n; ++i){
            d[i] = a[i];
            if(d[i] < d[i-1] + a[i])
                    d[i] = d[i-1] + a[i];

        }

        int max = d[0];
        for(int i = 1; i < n; ++i)
            if(max < d[i]) max = d[i];

        System.out.println(max);
    }
}
