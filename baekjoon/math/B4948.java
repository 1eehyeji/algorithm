package baekjoon.math;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// 4948번 베르트랑 공준 (https://www.acmicpc.net/problem/4948)
public class B4948 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());

		while (n != 0) {
			int m = 2 * n;

			int count = 0;

			for (int i = (n + 1); i <= m; ++i) {
				if (isPrimeNumber(i)) {
					++count;
				}
			}

			n = Integer.parseInt(br.readLine());

			bw.write(String.valueOf(count));
			bw.newLine();
		}

		br.close();
		bw.flush();
		bw.close();
	}

	private static boolean isPrimeNumber(int number) {
		if (number == 1) {
			return false;
		}

		for (int i = 2; i <= Math.sqrt(number); ++i) {
			if (number % i == 0) {
				return false;
			}
		}

		return true;
	}
}
