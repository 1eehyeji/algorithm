package baekjoon.Array;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2920_2 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int[] a = new int[8];
        for(int i = 0; i < 8; ++i){
            a[i] = Integer.parseInt(st.nextToken());
        }

        String s = "";
        for(int i = 0; i < 7; ++i){
            int num = a[i] - a[i+1];
            if(num == 1){
                s = "descending";
            }
            else if(num == -1){
                s = "ascending";
            }
            else{
                s = "mixed";
                break;
            }
        }

        System.out.println(s);
        br.close();
    }
}
