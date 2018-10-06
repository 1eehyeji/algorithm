package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2908 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        String s1 = st.nextToken();
        String s2 = st.nextToken();

        String r1 = "";
        String r2 = "";

        for(int i = s1.length()-1; i >= 0; --i) {
        	r1 += String.valueOf(s1.charAt(i));
        }
        for(int i = s2.length()-1; i >= 0; --i) {
        	r2 += String.valueOf(s2.charAt(i));
        }

        int a = Integer.parseInt(r1);
        int b = Integer.parseInt(r2);

        System.out.println(a > b ? a : b);
	}

}
