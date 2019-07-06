package baekjoon.graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B9466 {
	static int[] a;
	static int[] c;
	static int[] start;

	static int dfs(int v, int s, int count) {
		if(c[v] != 0) {
			if(start[v] != s) {
				return 0;
			}
			return count - c[v];
		}
		c[v] = count;
		start[v] = s;
		return dfs(a[v], s, count+1);
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int k = Integer.parseInt(br.readLine());

		while(k --> 0) {
			int n = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine(), " ");

			a = new int[100001];
			for(int i = 1; i <= n; ++i) {
				a[i] = Integer.parseInt(st.nextToken());
			}

			c = new int[100001];
			start = new int[100001];
			int ans = 0;
			for(int i = 1; i <= n; ++i) {
				if(c[i] == 0) {
					ans += dfs(i, i, 1);
				}
			}

			System.out.println(n - ans);
		}

		br.close();
	}

}
