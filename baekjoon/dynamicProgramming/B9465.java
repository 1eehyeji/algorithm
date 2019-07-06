package baekjoon.dynamicProgramming;

import java.util.Scanner;

public class B9465 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        int t = in.nextInt();

        for(int i = 0; i < t; ++i){

            int n = in.nextInt();
            int[][] d = new int[2][n+1];

            for(int j = 0; j < 2; ++j){
                for(int z = 1; z <= n; ++z){
                    d[j][z] = in.nextInt();
                }
            }

            int[][]p =new int[n+1][3];
            int result = 0;

            p[1][1] = d[0][1];
            p[1][2] = d[1][1];

            for(int j = 2; j <= n; ++j){
                for(int z = 0; z < 3; ++z)
                    if(p[j-1][z] > p[j][0]) p[j][0] = p[j-1][z];
                p[j][1] = Math.max(p[j-1][0], p[j-1][2]) + d[0][j];
                p[j][2] = Math.max(p[j-1][0], p[j-1][1]) + d[1][j];
            }

            for(int z = 0; z < 3; ++z)
                if(result < p[n][z]) result = p[n][z];

            System.out.println(result);
        }
    }
}
