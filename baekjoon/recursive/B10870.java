package baekjoon.recursive;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 10870 피보나치 수 5
*
* 반복문으로 구현할 수 있지만 재귀를 사용하여 구현해본다.
* */
public class B10870 {

	static int n;

	static int fibonacci(int i, int num1, int num2) {
		if (n <= 1) {
			return n;
		}

		if (i == n) {
			return num1 + num2;
		}

		int num3 = num1 + num2;

		return fibonacci(++i, num2, num3);
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());

		System.out.println(fibonacci(2, 0, 1));
	}
}
