package baekjoon.dynamicProgramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 1904번 01타일
*
* 처음에는 문제에서 값을 구하는 방식을 구현하여 값을 얻었는데 시간초과가 발생했다.
* 문제 해결을 위해 다른 사람들은 어떻게 접근했는지 찾아보았다.
* 해당 문제가 규칙을 찾는 방법을 통해 해결이 가능하다는 글을 보았고,
* 값을 나열한 뒤 피보나치와 같은 규칙이 있다는 것을 발견하여 구현하였다.
* */
public class B1904 {

	static long[] counts;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		counts = new long[1000001];
		counts[1] = 1;
		counts[2] = 2;

		if (N > 2) {
			countTiles(N, 3);
		}

		System.out.println(counts[N]);
	}

	private static void countTiles(int n, int m) {
		counts[m] = (counts[m - 2] + counts[m - 1]) % 15746;	// N 값이 커지면 피보나치 수가 long의 범위를 벗어나기 때문에 연산 과정에서 나머지를 취해주어야 함.

		if (n == m) {
			return;
		}

		countTiles(n, m + 1);
	}
}
