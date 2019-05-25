package baekjoon.Sort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/* 백준 10989번 수 정렬하기3
*
* N개의 수가 주어졌을 때, 이를 오름차순으로 정렬하는 프로그램을 작성하시오.
*
* 첫째 줄에 수의 개수 N(1 ≤ N ≤ 10,000,000)이 주어진다.
* 둘째 줄부터 N개의 줄에는 숫자가 주어진다. 이 수는 10,000보다 작거나 같은 자연수이다.
* 첫째 줄부터 N개의 줄에 오름차순으로 정렬한 결과를 한 줄에 하나씩 출력한다.
*/
public class B10989_2 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int[] numbers = new int[10001];

		while(N --> 0) {
			int index = Integer.parseInt(br.readLine());
			++numbers[index];
		}

		br.close();

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		for(int i = 1; i < numbers.length; ++i) {
			for(int j = 0; j < numbers[i]; ++j) {
				bw.write(String.valueOf(i));
				bw.newLine();
			}
		}

		bw.flush();
		bw.close();
	}
}
