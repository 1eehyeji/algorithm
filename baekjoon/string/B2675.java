package baekjoon.string;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2675 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        StringTokenizer st;
        while(t --> 0) {
            st = new StringTokenizer(br.readLine(), " ");
            int r = Integer.parseInt(st.nextToken());
            String s = st.nextToken();
            for(int i = 0; i < s.length(); ++i){
                char c = s.charAt(i);
                for(int j = 0; j < r; ++j)
                    System.out.print(c);
            }
            System.out.println();
        }

        br.close();
    }
}
