package baekjoon.Math;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1978 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int count = 0;

        for(int i = 0; i < n; ++i){
            int a = Integer.parseInt(st.nextToken());
            boolean check = true;
            if(a < 2) check = false;
            for(int j = 2; j*j <= a; ++j){
                if(a % j == 0){
                    check = false;
                    break;
                }
            }
            if(check) count += 1;
        }

        System.out.println(count);
    }
}
