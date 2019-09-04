package baekjoon.bruteForceSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 2231번 분해합 (https://www.acmicpc.net/problem/2231)
public class B2231 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int 자릿수 = (int) Math.log10(N);

		int start = (int) Math.pow(10, (자릿수 - 1));
		int end = (int) Math.pow(10, (자릿수 + 1));

		for (int i = start; i < end; ++i) {
			int num = i;
			int 분해합 = num;

			while (num > 0) {
				분해합 += num % 10;
				num /= 10;
			}

			if (분해합 == N) {
				System.out.print(i);
				return;
			}
		}

		System.out.print(0);
	}
}
