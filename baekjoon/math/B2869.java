package baekjoon.math;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 2869번 달팽이는 올라가고 싶다 (https://www.acmicpc.net/problem/2869)
public class B2869 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int A = Integer.parseInt(st.nextToken()); //올라가는 높이
		int B = Integer.parseInt(st.nextToken()); //내려기는 높이
		int V = Integer.parseInt(st.nextToken()); //나무의 길이

		double n = V - A;

		double day = A - B;

		int d = (int) Math.ceil(n / day) + 1;

		System.out.println(d);
	}
}
