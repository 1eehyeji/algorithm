package baekjoon.string;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B1157 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine().toUpperCase();
        int[] a = new int[26];

        for(int i = 0; i < s.length(); ++i){
            char c = s.charAt(i);
            int b = c - 'A';
            a[b] += 1;
        }

        int index = 0;
        int max = a[0];
        int count = 0;
        for(int i = 1; i < a.length; ++i){
            if(max == a[i]){
                count += 1;
            }
            if(max < a[i]){
                index = i;
                max = a[i];
                count = 0;
            }
        }

        if(count > 0) System.out.println("?");
        else{
            char c = (char)(index + 65);
            System.out.println(c);
        }

        br.close();
    }
}
