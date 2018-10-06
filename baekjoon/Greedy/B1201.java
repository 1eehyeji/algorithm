package baekjoon.Greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// NMK
public class B1201 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		if(n < m+k-1 || n > m*k)	// 조건을 만족하는 수열을 만들 수 없는 경우
			System.out.println("-1");
		else {

		}
		br.close();
	}

}
