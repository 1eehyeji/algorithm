package baekjoon.iO;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 1330번 두 수 비교하기 (https://www.acmicpc.net/problem/1330)
public class B1330 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());

		System.out.println(compare(A, B));
	}

	public static String compare(int A, int B) {
		if (A == B) {
			return "==";
		}

		return A > B ? ">" : "<";
	}
}
