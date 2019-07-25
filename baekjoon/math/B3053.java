package baekjoon.math;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 3053번 택시 기하학 (https://www.acmicpc.net/problem/3053)
public class B3053 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int R = Integer.parseInt(br.readLine());

		double u = Math.pow(R, 2) * Math.PI;	// R^2 * PI
		double t = 2 * Math.pow(R, 2);			// 2R^2 (두 대각선의 길이가 R인 마름모의 넓이와 같음)

		System.out.printf("%4f\n%4f", u, t);
	}
}
