package softeer.level3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 동계테스트시점예측 {

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] matrix = new int[N][M];

        for (int i = 0; i < N; ++i) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; ++j) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int count = 0;

        while (hasMoreIce(matrix)) {
            bfs(N, M, matrix, new int[N][M]);
            ++count;
        }

        System.out.print(count);

        br.close();
    }

    public static void bfs(int N, int M, int[][] matrix, int[][] visited) {
        visited[0][0] = 1;

        Queue<int[]> q = new LinkedList<int[]>();
        q.add(new int[]{0, 0});

        while (!q.isEmpty()) {
            int[] point = q.poll();

            for (int i = 0; i < 4; ++i) {
                int x = dx[i] + point[0];
                int y = dy[i] + point[1];

                if (x < 0 || x >= N || y < 0 || y >= M) {
                    continue;
                }

                if (matrix[x][y] == 1) {
                    ++visited[x][y];
                    continue;
                }

                if (visited[x][y] == 0) {
                    visited[x][y] = 1;
                    q.add(new int[]{x, y});
                }
            }
        }

        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < M; ++j) {
                if (visited[i][j] >= 2) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    public static boolean hasMoreIce(int[][] matrix) {
        for (int[] row : matrix) {
            for (int i : row) {
                if (i > 0) return true;
            }
        }

        return false;
    }
}
