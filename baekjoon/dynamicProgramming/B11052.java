package baekjoon.dynamicProgramming;

import java.util.Scanner;

public class B11052 {
    static int solution(int n, int[] p, int[] d){
        if(n == 1) return p[1];
        if(d[n] > 0) return d[n];
        for(int i = 1 ; i <= n; ++i){
            int temp = solution(n-i, p, d) + p[i];
            if(d[n] < temp) d[n] = temp;
        }
        return d[n];
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();

        in.nextLine();

        int[] p = new int[n+1];
        for(int i = 1; i <= n; ++i){
            p[i] = in.nextInt();
        }

        int[] d = new int[n+1];

        System.out.println(solution(n, p, d));
    }
}
