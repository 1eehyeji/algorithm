package baekjoon.math;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// 9020번 골드바흐의 추측 (https://www.acmicpc.net/problem/9020)
public class B9020 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		boolean[] primeNumbers = new boolean[10001];

		for (int i = 2; i < primeNumbers.length; ++i) {
			primeNumbers[i] = true;
		}

		makePrimeCheckArray(primeNumbers);

		int T = Integer.parseInt(br.readLine());

		while (T --> 0) {
			int n = Integer.parseInt(br.readLine());

			int a = n / 2;
			int b = n - a;

			while (b > 1) {
				if (primeNumbers[a] && primeNumbers[b]) {
					bw.write(a + " " + b);
					bw.newLine();
					break;
				}

				--a;
				++b;
			}
		}

		br.close();

		bw.flush();
		bw.close();
	}

	static void  makePrimeCheckArray(boolean[] primeNumbers) {
		for (int i = 2; i < primeNumbers.length; ++i) {
			if (!primeNumbers[i]) {
				continue;
			}

			for (int j = i * 2; j < primeNumbers.length; j += i) {
				primeNumbers[j] = false;
			}
		}
	}
}