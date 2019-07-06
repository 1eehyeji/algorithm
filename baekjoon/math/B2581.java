package baekjoon.math;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * 백준 2581번 소수
 *
 * 자연수 M과 N이 주어질 때 M이상 N 이하의 자연수 중 소수인 것을 모두 골라 이들 소수의 합과 최솟값을 찾는 프로그램을 작성하시오.
 *
 * M과 N은 10,000이하의 자연수이며, M은 N보다 작거나 같다.
 * M이상 N 이하의 자연수 중 소수가 없을 경우는 첫째 줄에 -1을 출력한다.
 *
 * '에라토스네스의 체' 로 접근하여 문제 해결
 * */
public class B2581 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int M = Integer.parseInt(br.readLine());
		int N = Integer.parseInt(br.readLine());

		br.close();

		List<Integer> primeNumbers = new ArrayList<>();

		for (int i = M; i <= N; ++i) {
			if (isPrimeNumber(i)) {
				primeNumbers.add(i);
			}
		}

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		if (primeNumbers.isEmpty()) {
			bw.write(String.valueOf(-1));
		} else {
			int sum = primeNumbers.stream()
					.reduce((p1, p2) -> p1 + p2)
					.get();

			bw.write(sum + "\n" + primeNumbers.get(0));
		}

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
