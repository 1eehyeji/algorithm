package baekjoon.String;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B8958 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while(t --> 0){
            String s = br.readLine();
            int result = 0;
            int count = 0;
            for(int i = 0; i < s.length(); ++i){
                char c = s.charAt(i);
                if(c == 'O'){
                    result += 1 + count;
                    ++count;
                }
                else if (c == 'X'){
                    count = 0;
                }
            }
            System.out.println(result);
        }

        br.close();
    }
}
