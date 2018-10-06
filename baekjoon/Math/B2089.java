package baekjoon.Math;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B2089 {
    static void solution(int n){
        if(n == 0) return;
        else{
            if(n % 2 == 0){     // n값이 짝수일 경우
                solution(-(n/2));
                System.out.print(0);
            }
            else {              // n값이 홀수일 경우
                if(n > 0){
                    solution(-(n/2));
                }
                else{
                    solution((-n+1)/2);
                }
                System.out.print(1);
            }
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        if(n == 0) System.out.println(0);
        else{
            solution(n);
            System.out.println();
        }
    }
}
