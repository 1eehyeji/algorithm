package leetCode;

import java.util.*;

// Detonate the Maximum Bombs
public class Solution2101 {

    public static int maximumDetonation(int[][] bombs) {
        List<Integer>[] graph = new ArrayList[bombs.length];

        for (int i = 0; i < bombs.length; ++i) {
            int x = bombs[i][0];
            int y = bombs[i][1];
            int r = bombs[i][2];

            List<Integer> list = new ArrayList<>();

            for (int j = 0; j < bombs.length; ++j) {
                if (i == j) continue;

                int x2 = bombs[j][0];
                int y2 = bombs[j][1];

                if (Math.pow(r, 2) >= (Math.pow(x - x2, 2) + Math.pow(y - y2, 2))) {
                    list.add(j);
                }
            }

            graph[i] = list;
        }

        int max = 0;

        boolean[] isChecked;

        for (int i = 0; i < bombs.length; ++i) {
            isChecked = new boolean[bombs.length];
            max = Math.max(max, dfs(graph, isChecked, i));
        }

        return max;
    }

    private static int dfs(List<Integer>[] graph, boolean[] isChecked, int n) {
        if (isChecked[n]) {
            return 0;
        }

        isChecked[n] = true;

        int count = 1;

        for (int i = 0; i < graph[n].size(); ++i) {
            count += dfs(graph, isChecked, graph[n].get(i));
        }

        return count;
    }

    public static void main(String[] args) {
        int[][] bombs = {{1, 2, 3}, {2, 3, 1}, {3, 4, 2}, {4, 5, 3}, {5, 6, 4}};

        System.out.println(maximumDetonation(bombs));
    }
}
