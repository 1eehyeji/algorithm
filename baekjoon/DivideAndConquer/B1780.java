package baekjoon.DivideAndConquer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1780 {

	public static boolean check(int[][] a, int x, int y, int n) {
		for(int i = x; i < x+n; ++i) {
			for(int j = y; j < y+n; ++j) {
				if(a[x][y] != a[i][j]) {
					return false;
				}
			}
		}
		return true;
	}

	public static void solution(int[][] a, int[] cnt, int x, int y, int n) {
		if(check(a, x, y, n)) {				// 종이를 그대로 사용할 수 있음
			cnt[a[x][y]+1] += 1;
			return;
		}
		int m = n/3;
		for(int i = 0; i < 3; ++i) {		// 종이를 사용할 수 없으면 종이를 자르고 재귀호출
			for(int j = 0; j < 3; ++j) {
				solution(a, cnt, x+i*m, y+j*m, m);
			}
		}
	}

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine()); // (1 <= n <= 3^7)
		int[][] a = new int[n][n];
		int[] cnt = new int[3];		// -1, 0, 1 가 저장되어있는 종이의 개수

		StringTokenizer st;

		for (int i = 0; i < n; ++i) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; ++j) {
				a[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		solution(a, cnt, 0, 0, n);
		for(int i = 0; i < 3; ++i)
			System.out.println(cnt[i]);
	}

}
