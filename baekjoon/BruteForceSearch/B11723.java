package baekjoon.BruteForceSearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B11723 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int m = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int n = 0;
		while(m --> 0) {
			st = new StringTokenizer(br.readLine());
			String s = st.nextToken();
			int x = 0;
			if (st.hasMoreTokens()) {
				x = Integer.parseInt(st.nextToken());
			}
			switch(s) {
			case "add":
				n |= (1 << x);
				break;
			case "remove":
				n &= ~(1 << x);
				break;
			case "check":
				if((n & (1 << x)) > 0) {
					sb.append("1\n");
				} else {
					sb.append("0\n");
				}
				break;
			case "toggle":
				n ^= (1 << x);
				break;
			case "all":
				n = (1 << 21) - 1 - 1; // 코드마다 다름ㅜㅜ
				break;
			case "empty":
				n = 0;
				break;
			}
		}
		System.out.println(sb.toString());
	}

}
