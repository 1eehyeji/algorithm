package baekjoon.divideAndConquer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// 11729번 하노이 탑 이동 순서 (https://www.acmicpc.net/problem/11729)
// 시간 초과 문제 BufferedWriter 로 해결
public class B11729 {

	static BufferedWriter bw;

	static void solve(int n, int x, int y) throws Exception {
		if(n == 0) return;
		solve(n-1, x, 6-x-y);	// 제일 아래쪽 탑을 제외한 탑의 이동순서
		bw.write(x + " " + y + "\n");	// 아래쪽 탑을 3으로 이동함
		solve(n-1, 6-x-y, y);	// 나머지 탑을 3으로 옮기는 순서
	}

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());

		bw.write((int)(Math.pow(2, n) - 1) + "\n"); // 이동횟수는 d[n-1] + d[n-1] + 1 = 2 * d[n-1] + 1 = 2^n - 1

		solve(n, 1, 3);

		bw.flush();
		bw.close();
		br.close();
	}

}
