package leetCode;

// Detonate the Maximum Bombs
public class Solution2101 {

    public static int maximumDetonation(int[][] bombs) {
        boolean[][] graph = new boolean[bombs.length][bombs.length];

        for (int i = 0; i < bombs.length; ++i) {
            int x = bombs[i][0];
            int y = bombs[i][1];
            int r = bombs[i][2];

            for (int j = 0; j < bombs.length; ++j) {
                if (i == j) continue;

                int x2 = bombs[j][0];
                int y2 = bombs[j][1];

                if (Math.pow(r, 2) >= (Math.pow(x - x2, 2) + Math.pow(y - y2, 2))) {
                    graph[i][j] = true;
                }
            }
        }

        int max = 0;

        for (int i = 0; i < bombs.length; ++i) {
            int k = dfs(graph, new boolean[bombs.length], i);

            if (k == bombs.length) {
                return k;
            }

            max = Math.max(max, k);
        }

        return max;
    }

    private static int dfs(boolean[][] graph, boolean[] isChecked, int n) {
        if (isChecked[n]) {
            return 0;
        }

        isChecked[n] = true;

        int count = 1;

        for (int i = 0; i < graph.length; ++i) {
            if (graph[n][i]) {
                count += dfs(graph, isChecked, i);
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[][] bombs = {{1, 2, 3}, {2, 3, 1}, {3, 4, 2}, {4, 5, 3}, {5, 6, 4}};

        System.out.println(maximumDetonation(bombs));
    }
}
