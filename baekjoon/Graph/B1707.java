package baekjoon.Graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class B1707 {
	static ArrayList<Integer>[] a;
	static int[] color; // 0->방문안함 1, 2-> 색깔
	static int v;

	static void dfs(int u, int c) {
		color[u] = c;
		for(int i : a[u]) {
			if(color[i] == 0)
				dfs(i, 3-c);
		}
	}

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int k = Integer.parseInt(br.readLine());

		StringTokenizer st;

		for(int i = 0; i < k; ++i) {
			st = new StringTokenizer(br.readLine(), " ");
			v = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());

			a = new ArrayList[v+1];
			for(int j = 1; j <= v; ++j)
				a[j] = new ArrayList<>();

			for(int j = 0; j < e; ++j) {
				st = new StringTokenizer(br.readLine(), " ");
				int u = Integer.parseInt(st.nextToken());
				int w = Integer.parseInt(st.nextToken());
				a[u].add(w);
				a[w].add(u);
			}
			for(int j = 1; j <= v; ++j)
				Collections.sort(a[j]);

			color = new int[v+1];
			for(int j = 1; j <= v; ++j) {
				if(color[j] == 0)
					dfs(j, 1);
			}

			boolean check = true;
			for(int j = 1; j <= v; ++j) {
				for(int l : a[j]) {
					if(color[j] == color[l])
						check = false;
				}
			}

			System.out.println(check ? "YES" : "NO");
		}
	}

}
