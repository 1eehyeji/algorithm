package baekjoon.divideAndConquer;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 백준 2448번 별찍기 - 11
*  첫째 줄에 N이 주어진다. N은 항상 3×2k 수이다. (3, 6, 12, 24, 48, ...) (k ≤ 10)
* */
public class B2448_2 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int k = (int)(Math.log(n/3)/Math.log(2));   // n = 3*2^k 에서 k값을 구함

        String[] star = new String[n];
        star[0] = "  *  ";
        star[1] = " * * ";
        star[2] = "*****";

        int h = 3;  // 현재 높이

        for(int i = 1; i <= k; ++i) {

            for(int j = 0; j < h; ++j) {
                star[h + j] = star[j] + " " + star[j];

                for(int t = 0; t < (h/3); ++t){
                    star[j] = "   " + star[j] + "   ";
                }

            }

            h *= 2;    // 위에서 h만큼 반복문을 돌면서 배열을 채우기 때문에 2배를 해줌
        }

        for (String s : star) {
            System.out.println(s);
        }
    }
}
