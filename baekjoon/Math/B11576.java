package baekjoon.Math;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B11576 {
    static void solution(int num, int B){
        if(num == 0) return;
        solution(num / B, B);
        System.out.print(num % B + " ");
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine(), " ");

        int result = 0;
        for(int i = 0; i < m; ++i){
            int n = Integer.parseInt(st.nextToken());
            result = result * A + n;        // 10진수로 변환
        }

        solution(result, B);
        System.out.println();
    }
}
