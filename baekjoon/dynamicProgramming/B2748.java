package baekjoon.dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2748 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		long[] fibonacci = new long[n + 1]; 								// n이 일정 숫자 이상이 되면 int로는 모든 값을 표현할 수 없음

		fibonacci[0] = 0;
		fibonacci[1] = 1;

		int count = 2;

		while (count <= n) {
			fibonacci[count] = fibonacci[count - 1] + fibonacci[count - 2];
			++count;
		}

		System.out.println(fibonacci[n]);
	}
}
