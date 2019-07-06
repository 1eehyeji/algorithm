package baekjoon.divideAndConquer;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B2447 {
	static StringBuffer sb;

	static void solve(int i, int j) {
		while(i > 0 && j > 0) {
			if(i % 3 == 1 && j % 3 == 1) {
				sb.append(" ");
				return;
			}
			i /= 3;
			j /= 3;
		}
		sb.append("*");
	}

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		sb = new StringBuffer();

		for(int i = 0; i < n; ++i) {
			for(int j = 0; j < n; ++j) {
				solve(i, j);
			}
			sb.append("\n");
		}

		System.out.println(sb.toString());
	}

}
