package baekjoon.Math;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2745 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        String n = st.nextToken();
        int b = Integer.parseInt(st.nextToken());
        int result = 0;
        for(int i = 0; i < n.length(); ++i){
            char c = n.charAt(i);
            if(c < 'A'){
                result = result * b + (c - '0');
            } else {
                result = result * b + (c -'A' + 10);
            }
        }
        System.out.println(result);
    }
}
