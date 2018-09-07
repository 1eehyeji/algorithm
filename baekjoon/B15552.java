package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class B15552 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());

        while(t --> 0){
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = a + b;
            bw.write(String.valueOf(c)); //valueOf 사용하지 않으면 아스키코드로 출력됨
            bw.newLine();
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
