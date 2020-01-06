package baekjoon.bruteForceSearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 1436번 영화감독 숌
*
*
* */
public class B1436 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int number = 666;
		int count = 0;
		String answer;

		while (true) {
			String value = String.valueOf(number);

			if (value.contains("666")) {
				++count;

				if (N == count) {
					answer = value;
					break;
				}
			}

			++number;
		}

		System.out.println(answer);
	}
}
