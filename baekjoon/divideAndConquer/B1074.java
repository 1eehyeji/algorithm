package baekjoon.divideAndConquer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1074 {
	static int r;
	static int c;
	static int count;

	static void solve(int i, int j, int n) {
		if(n == 1) {
			if(i == r && j == c)	// i, j 값이 r, c와 같으면 count 출력
				System.out.println(count);
			++count;
			return;
		}

		if (!(i <= r && r < i + n && j <= c && c < j + n)) {
			count += n * n;
			return;
		}

		int m = n/2;
		solve(i , j, m);	//왼쪽 위
		solve(i , j+m, m);	// 오른쪽 위
		solve(i+m , j, m);	// 왼쪽 아래
		solve(i+m, j+m, m);	// 오른쪽 아래
	}

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		count = 0;

		int m = (int)Math.pow(2, n);

		solve(0, 0, m);

	}

}
