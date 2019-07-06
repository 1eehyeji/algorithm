package baekjoon.divideAndConquer;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B11729 {

	static void solve(int n, int x, int y) {
		if(n == 0) return;
		solve(n-1, x, 6-x-y);	// 제일 아래쪽 탑을 제외한 탑의 이동순서
		System.out.println(x + " " + y);	// 아래쪽 탑을 3으로 이동함
		solve(n-1, 6-x-y, y);	// 나머지 탑을 3으로 옮기는 순서
	}

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		System.out.println((int) (Math.pow(2, n) - 1)); // 이동횟수는 d[n-1] + d[n-1] + 1 = 2 * d[n-1] + 1 = 2^n - 1

		solve(n, 1, 3);
	}

}
