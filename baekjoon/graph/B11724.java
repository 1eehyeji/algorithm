package baekjoon.graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class B11724 {
	static ArrayList<Integer>[] list;
	static boolean[] b;

	static void dfs(int v) {
		if(b[v] == true) return;
		b[v] = true;
		for(int x : list[v]) {
			if(b[x] == false)
				dfs(x);
		}
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		list = new ArrayList[n+1];

		for(int i = 1; i <= n; ++i)
			list[i] = new ArrayList<>();

		for(int i = 0; i < m; ++i) {
			st = new StringTokenizer(br.readLine(), " ");
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			list[u].add(v);
			list[v].add(u);
		}

		for (int i = 1; i <= n; i++) {
            Collections.sort(list[i]);
        }

		b = new boolean[n+1];

		int count = 0;

		for(int i = 1; i <= n; ++i) {
			if(b[i] == false) {
				count += 1;
				dfs(i);
			}
		}

		System.out.println(count);

		br.close();
	}

}
