package baekjoon.dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1149 {

	static int N;
	static int [][] colorCost;
	static int [][] totalCost;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		colorCost = new int[N + 1][3];
		totalCost = new int[N + 1][3];

		String s = "";
		StringTokenizer st;
		int M = 1;

		while (M <= N) {
			s = br.readLine();
			st = new StringTokenizer(s, " ");
			int count = 0;

			while (st.hasMoreTokens()) {
				colorCost[M][count] = Integer.parseInt(st.nextToken());
				++count;
			}

			++M;
		}

		br.close();

		for (int i = 1; i <= N; ++i) {
			int pre = i - 1;

			totalCost[i][0] = Math.min(totalCost[pre][1], totalCost[pre][2]) + colorCost[i][0];
			totalCost[i][1] = Math.min(totalCost[pre][0], totalCost[pre][2]) + colorCost[i][1];
			totalCost[i][2] = Math.min(totalCost[pre][0], totalCost[pre][1]) + colorCost[i][2];
		}

		System.out.println(Math.min(totalCost[N][0], Math.min(totalCost[N][1], totalCost[N][2])));
	}
}
