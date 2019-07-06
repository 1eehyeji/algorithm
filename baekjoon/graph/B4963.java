package baekjoon.graph;

import java.util.Scanner;

public class B4963 {
	static int[] xp = { 0, 1, 0, -1, -1, 1, 1, -1 };
	static int[] yp = { 1, 0, -1, 0, 1, 1, -1, -1 };

	static void dfs(int[][] a, int[][] numbers, int x, int y, int number, int n, int m){
		numbers[x][y] = number;
		for(int i = 0; i < 8; ++i){
			int nextX = x + xp[i];
			int nextY = y + yp[i];
			if(0 <= nextX && nextX < m && 0 <= nextY && nextY < n){
				if(a[nextX][nextY] == 1 && numbers[nextX][nextY] == 0){
					dfs(a, numbers, nextX, nextY, number, n, m);
				}
			}
		}
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		while (true) {
			int n = in.nextInt();
			int m = in.nextInt();

			if(n == 0 && m ==0) break;

			int[][] a = new int[m][n];
			for (int i = 0; i < m; ++i) {
				for (int j = 0; j < n; ++j) {
					a[i][j] = in.nextInt();
				}
			}

			int number = 0;
			int[][] numbers = new int[m][n];
			for (int i = 0; i < m; ++i) {
				for (int j = 0; j < n; ++j) {
					if (a[i][j] == 1 && numbers[i][j] == 0) {
						++number;
						dfs(a, numbers, i, j, number, n, m);
					}
				}
			}

			System.out.println(number);
		}

		in.close();
	}
}
