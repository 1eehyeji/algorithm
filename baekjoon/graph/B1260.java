package baekjoon.graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B1260 {
	static boolean[] b;
	static ArrayList<Integer>[] list;

	static void dfs(int v) {
		if(b[v] == true) return;
		b[v] = true;
		System.out.print(v + " ");
		for(int x : list[v]) {
			if(b[x] == false)
				dfs(x);
		}
	}

	static void bfs(int v) {
		if(b[v]) return;
		Queue<Integer> queue = new LinkedList<>();
		b[v] = true;
		queue.add(v);

		while(!queue.isEmpty()) {
			int v1 = queue.remove();
			System.out.print(v1 + " ");
			for (int u : list[v1]) {
                if (b[u] == false) {
                    b[u] = true;
                    queue.add(u);
                }
			}
		}
	}

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken()); // 정점의 개수
		int m = Integer.parseInt(st.nextToken()); // 간선의 개수
		int v = Integer.parseInt(st.nextToken()); // 탐색 시작 정점

		list = new ArrayList[n+1];

		for(int i = 1; i <= n; ++i)
			list[i] = new ArrayList<Integer>();

		for(int i = 0; i < m; ++i) {
			st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			list[v1].add(v2);
			list[v2].add(v1);
		}

		for (int i = 1; i <= n; i++) {
            Collections.sort(list[i]);
        }

		b = new boolean[n+1];
		dfs(v);
		System.out.println();

		b = new boolean[n+1];
		bfs(v);
		System.out.println();

		br.close();
	}

}
