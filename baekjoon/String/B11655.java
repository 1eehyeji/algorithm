package baekjoon.String;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B11655 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        br.close();

        StringBuilder builder = new StringBuilder();

        for(int i = 0; i < s.length(); ++i){
            char c = s.charAt(i);
            char ch;
            if(96 < c && c < 123){
                ch = (char)((c - 'a' + 13) % 26 + 'a');
                builder.append(ch);
            }
            else if(64 < c && c < 91) {
                ch = (char) ((c - 'A' + 13) % 26 + 'A');
                builder.append(ch);
            }
            else builder.append(c);
        }
        System.out.println(builder.toString());
    }
}
