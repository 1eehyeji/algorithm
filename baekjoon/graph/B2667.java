package baekjoon.graph;

import java.util.Arrays;
import java.util.Scanner;

public class B2667 {
	static int[] xp = { 0, 1, 0, -1 };
	static int[] yp = { 1, 0, -1, 0 };

	static void dfs(int[][] a, int[][] numbers, int x, int y, int number, int n){
		numbers[x][y] = number;
		for(int i = 0; i < 4; ++i){
			int nextX = x + xp[i];
			int nextY = y + yp[i];
			if(0 <= nextX && nextX < n && 0 <= nextY && nextY < n){
				if(a[nextX][nextY] == 1 && numbers[nextX][nextY] == 0){
					dfs(a, numbers, nextX, nextY, number, n);
				}
			}
		}
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		in.nextLine();

		int[][] a = new int[n][n];
		for(int i = 0; i < n; ++i){
			String s = in.nextLine();
			for(int j = 0; j < n; ++j){
				a[i][j] = s.charAt(j) - '0';
			}
		}

		int number = 0;
		int[][] numbers = new int[n][n];
		for(int i = 0; i < n; ++i){
			for(int j = 0; j < n; ++j){
				if(a[i][j] == 1 && numbers[i][j] == 0){
					++number;
					dfs(a, numbers, i, j, number, n);
				}
			}
		}

		int[] result = new int[number];
		for(int i = 0; i < n; ++i){
			for(int j = 0; j < n; ++j){
				if(numbers[i][j] != 0){
					result[numbers[i][j] - 1] += 1;
				}
			}
		}

		Arrays.sort(result);
		System.out.println(number);
		for(int i : result)
			System.out.println(i);

		in.close();
	}

}
