package baekjoon.Rule;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/* 백준 2775번 부녀회장이 될테야
*
* “a층의 b호에 살려면 자신의 아래(a-1)층의 1호부터 b호까지
* 사람들의 수의 합만큼 사람들을 데려와 살아야 한다” 는 계약 조항을 꼭 지키고 들어와야 한다.
* 아파트에 비어있는 집은 없고 모든 거주민들이 이 계약 조건을 지키고 왔다고 가정했을 때,
* 주어지는 양의 정수 k와 n에 대해 k층에 n호에는 몇 명이 살고 있는지 출력하라.
* 단, 아파트에는 0층부터 있고 각층에는 1호부터 있으며, 0층의 i호에는 i명이 산다.
*
* 첫 번째 줄에 Test case의 수 T가 주어진다.
* 리고 각각의 케이스마다 입력으로 첫 번째 줄에 정수 k, 두 번째 줄에 정수 n이 주어진다.
* (1 <= k <= 14, 1 <= n <= 14)
* */
public class B2775 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());

		int[][] apartment = new int[15][15];
		apartment[0][0] = 2;

		for(int i = 1; i < 15; ++i) {
			apartment[0][i] = apartment[i][0] = apartment[0][i-1] + 1;
			for (int j = 1; j < i+1; ++j) {
				apartment[i][j] = apartment[j][i] = apartment[i-1][j] + apartment[i][j-1];
			}
		}

		while (T --> 0) {
			int k = Integer.parseInt(br.readLine());
			int n = Integer.parseInt(br.readLine());

			if(n == 1) {
				bw.write("1");
				bw.newLine();
				continue;
			}

			bw.write(String.valueOf(apartment[n-2][k]));
			bw.newLine();
		}

		bw.flush();

		bw.close();
		br.close();
	}
}
