package baekjoon.Math;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1929 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int a =  Integer.parseInt(st.nextToken());
        int b =  Integer.parseInt(st.nextToken());
        for(int i = a; i <= b; ++i){
            boolean check = true;
            if(i < 2) check = false;
            for(int j = 2; j*j <= i; ++j){
                if(i % j == 0){
                    check = false;
                    break;
                }
            }
            if(check) System.out.println(i);
        }
    }
}
