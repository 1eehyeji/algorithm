package baekjoon.DivideAndConquer;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B1992 {

	static boolean check(int[][] a, int i, int j, int n) {	// 같은 값으로만 이루어져있는지 검사
		for(int x = i; x < i+n; ++x) {
			for(int y = j; y < j+n; ++y) {
				if(a[i][j] != a[x][y])
					return false;
			}
		}
		return true;
	}

	static void solution(int[][] a, int i, int j, int n) {
		if(check(a, i, j, n)) {
			System.out.print(a[i][j]);	// 같은 값으로만 이루어져 있으면 그 값을 출력(n이 1인 경우 포함)
			return;
		}

		int m = n/2;	// 영상을 4개의 부분으로 나눔
		System.out.print("(");
		for(int x = 0; x < 2; ++x) {
			for(int y = 0; y < 2; ++y) {
				solution(a, i+x*m, j+y*m, m);	// 총 4번의 재귀함수가 호출됨
			}
		}
		System.out.print(")");
	}

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		int[][] a = new int[n][n];
		for(int i = 0; i < n; ++i) {
			String s = br.readLine();
			for(int j = 0; j < n; ++j) {
				a[i][j] = s.charAt(j) - '0';
			}
		}

		solution(a, 0, 0, n);
	}

}
