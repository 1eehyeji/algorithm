package baekjoon.Graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B10451 {
	static int[] a;
	static boolean[] c;

	static void dfs(int v) {
		if(c[v]) return;
		c[v] = true;
		dfs(a[v]);
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int k = Integer.parseInt(br.readLine());

		while(k --> 0) {
			int n = Integer.parseInt(br.readLine()); //순열의 크기
			a = new int[n+1];
			st = new StringTokenizer(br.readLine(), " ");
			for(int i = 1; i <= n; ++i) {
				a[i] = Integer.parseInt(st.nextToken());
			}
			c = new boolean[n+1];
			int count = 0;
			for(int i = 1; i <= n; ++i) {
				if(c[i] == false) {
					count += 1;
					dfs(i);
				}
			}
			System.out.println(count);
		}
		br.close();
	}

}
