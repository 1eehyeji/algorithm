package baekjoon.array;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* 10818번 최소, 최대
*
* N개의 정수가 주어진다. 이때, 최솟값과 최댓값을 구하는 프로그램을 작성하시오.
*
* 첫째 줄에 정수의 개수 N (1 ≤ N ≤ 1,000,000)이 주어진다. 둘째 줄에는 N개의 정수를 공백으로 구분해서 주어진다.
* 모든 정수는 -1,000,000보다 크거나 같고, 1,000,000보다 작거나 같은 정수이다.
 * */
public class B10818 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());

		int[] numbers = new int[N];

		for (int i = 0; i < N; ++i) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}

		System.out.println(findMinMax(numbers));
	}

	public static String findMinMax(int[] numbers) {
		int max = -1000000;
		int min = 1000000;

		for (int i : numbers) {
			if (i < min) {
				min = i;
			}
			if (i > max) {
				max = i;
			}
		}

		return min + " " + max;
	}
}
