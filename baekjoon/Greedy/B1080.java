package baekjoon.Greedy;

import java.util.Scanner;

//행렬
public class B1080 {
	static int[][] a;

	static void reverse(int n, int m) {	//a[i][j]와 b[i][j]가 다른 경우 해당 3*3 부분행렬 값을 뒤집어줌
		for(int i = n; i <= n+2; ++i) {
			for(int j = m; j <= m+2; ++j) {
				a[i][j] = 1 - a[i][j];
			}
		}
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		int n = input.nextInt();
		int m = input.nextInt();
		input.nextLine();

		a = new int[n][m];
		for(int i = 0; i < n; ++i) {
			String s = input.nextLine();
			for(int j = 0; j < m; ++j) {
				a[i][j] = s.charAt(j) - '0';
			}
		}

		int[][] b = new int[n][m];
		for(int i = 0; i < n; ++i) {
			String s = input.nextLine();
			for(int j = 0; j < m; ++j) {
				b[i][j] = s.charAt(j) - '0';
			}
		}

		int count = 0;	//연산 횟수를 저장할 변수

		for(int i = 0; i <= n-3; ++i) {
			for(int j = 0; j <= m-3; ++j) {
				if(a[i][j] != b[i][j]) {
					reverse(i, j);
					++count;
				}
			}
		}

		for(int i = 0; i < n; ++i) {
			for(int j = 0; j < m; ++j) {
				if(a[i][j] != b[i][j]) {	// 연산 후 a와 b가 같지 않으면 -1 출력
					count = -1;
					break;
				}
			}
		}
		System.out.println(count);
		input.close();
	}
}
