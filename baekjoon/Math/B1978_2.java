package baekjoon.Math;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 1978번 소수 찾기
 *
 * 주어진 수 N개 중에서 소수가 몇 개인지 찾아서 출력하는 프로그램을 작성하시오.
 * 첫 줄에 수의 개수 N이 주어진다. N은 100이하이다.
 * 다음으로 N개의 수가 주어지는데 수는 1,000 이하의 자연수이다.
 *
 * '에라토스네스의 체' 로 접근하여 문제 해결
 *
* */
public class B1978_2 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int count = 0;

		while (N --> 0) {
			if (isPrimeNumber(Integer.parseInt(st.nextToken()))) {
				++count;
			}
		}

		System.out.println(count);
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
