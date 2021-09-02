package baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 안전 영역
public class B2468 {
    static int[] xp = {0, 1, 0, -1};
    static int[] yp = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[][] areas = new int[N][N];
        boolean[][] isChecked = new boolean[N][N];
        StringTokenizer st;
        for (int i = 0; i < N; ++i) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; ++j) {
                areas[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int max = 0;

        for (int i = 0; i <= 100; ++i) {
            max = Math.max(max, getAreaCount(areas, isChecked, i));
            isChecked = new boolean[N][N];
        }

        System.out.println(max);
    }

    private static int getAreaCount(int[][] areas, boolean[][] isChecked, int depth) {
        int count = 0;

        for (int i = 0; i < areas.length; ++i) {
            for (int j = 0; j < areas.length; ++j) {
                if (areas[i][j] > depth && !isChecked[i][j]) {
                    isChecked[i][j] = true;
                    ++count;
                    dfs(areas, isChecked, i, j, depth);
                }
            }
        }

        return count;
    }

    private static void dfs(int[][] areas, boolean[][] isChecked, int x, int y, int depth) {
        for (int i = 0; i < 4; ++i) {
            int nextX = x + xp[i];
            int nextY = y + yp[i];
            if (0 <= nextX && nextX < areas.length && 0 <= nextY && nextY < areas.length) {
                if (areas[nextX][nextY] > depth && !isChecked[nextX][nextY]) {
                    isChecked[nextX][nextY] = true;
                    dfs(areas, isChecked, nextX, nextY, depth);
                }
            }
        }
    }
}
