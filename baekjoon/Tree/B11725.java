package baekjoon.Tree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B11725 {

	public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        ArrayList<Integer>[] a = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) {
            a[i] = new ArrayList<Integer>();
        }

        StringTokenizer st;
        for (int i = 0; i < n-1; i++) {
        	st = new StringTokenizer(br.readLine(), " ");
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            a[u].add(v);
            a[v].add(u);
        }

        boolean[] c = new boolean[n+1];
        int[] p = new int[n+1];
        //bfs
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(1);
        c[1] = true;
        while (!q.isEmpty()) {
            int x = q.remove();
            for (int y : a[x]) {
                if (c[y] == false) {
                    c[y] = true;
                    p[y] = x;
                    q.add(y);
                }
            }
        }

        for (int i=2; i<=n; i++) {
            System.out.println(p[i]);
        }
    }
}
