package baekjoon.math;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 1712번 손익분기점 (https://www.acmicpc.net/problem/1712)
public class B1712 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		long A = Long.valueOf(st.nextToken()); // 고정비용
		long B = Long.valueOf(st.nextToken()); // 가변비용
		long C = Long.valueOf(st.nextToken()); // 노트북 가격

		int count = 0;

		if (B < C) {
			long interest = C - B;
			count = (int) ((A / interest) + 1);
		}

		System.out.println(count == 0 ? -1 : count);
	}
}
