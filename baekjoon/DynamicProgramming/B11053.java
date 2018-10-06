package baekjoon.DynamicProgramming;

import java.util.Scanner;

public class B11053 {
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
            d[i] = 1;
            for(int j = 0; j < i; ++j){
                // a[i]를 마지막으로 하는 가장 긴 부분 수열을 구하기 위해서는 a[i]보다 큰 값이 존재하면 안됨
                // 앞서 구한 수열 중 가장 긴 수열의 값에 1을 더하여 d[i] 값을 구함
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
