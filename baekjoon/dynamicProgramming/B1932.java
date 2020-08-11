package baekjoon.dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* 1932번 정수 삼각형
*/
public class B1932 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int[][] costs = new int[N + 1][N + 1];
		int[][] totalCosts = new int[N + 1][N + 1];

		String s = "";
		StringTokenizer st;

		for (int i = 1; i <= N; ++i) {
			s = br.readLine();
			st = new StringTokenizer(s, " ");

			for (int j = 0; j < i; ++j) {
				costs[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		br.close();

		int max = 0;

		for (int i = 1; i <= N; ++i) {
			for (int j = 0; j < i; ++j) {
				if (j == 0) {
					totalCosts[i][j] = totalCosts[i - 1][j] + costs[i][j];
				} else {
					totalCosts[i][j] = Math.max(totalCosts[i - 1][j], totalCosts[i - 1][j - 1]) + costs[i][j];
				}

				if (max < totalCosts[i][j]) {	// 값을 계속 검사하면서 최대 값을 업데이트함
					max = totalCosts[i][j];
				}
			}
		}

		/* 정렬 후 가장 뒷 쪽에 있는 값을 출력함
		Arrays.sort(totalCosts[N]);
		System.out.println(totalCosts[N][N]);
		*/

		System.out.println(max);
	}
}
