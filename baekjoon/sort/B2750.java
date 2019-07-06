package baekjoon.sort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

/* 백준 2750번 수 정렬하기
*
* N개의 수가 주어졌을 때, 이를 오름차순으로 정렬하는 프로그램을 작성하시오.
*
* 첫째 줄에 수의 개수 N(1 ≤ N ≤ 1,000)이 주어진다. 둘째 줄부터 N개의 줄에는 숫자가 주어진다.
* 이 수는 절댓값이 1,000보다 작거나 같은 정수이다. 수는 중복되지 않는다.
*
* 첫째 줄부터 N개의 줄에 오름차순으로 정렬한 결과를 한 줄에 하나씩 출력한다.
 */
public class B2750 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());

		int[] a = new int[N];
		while (N --> 0) {
			a[N] = Integer.parseInt(br.readLine());
		}

		br.close();

		Arrays.parallelSort(a);

		for (int i : a) {
			bw.write(String.valueOf(i));
			bw.newLine();
		}

		bw.flush();
		bw.close();
	}
}
