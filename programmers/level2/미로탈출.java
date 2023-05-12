package programmers.level2;

import java.util.LinkedList;
import java.util.Queue;

public class 미로탈출 {

    static int[] dx = {-1, 1, 0 ,0};
    static int[] dy = {0, 0, -1, 1};

    public static int solution(String[] maps) {
        int answer = -1;

        Queue<Integer> xQ = new LinkedList<>();
        Queue<Integer> yQ = new LinkedList<>();
        boolean[][] visited = new boolean[maps.length][maps[0].length()];
        int[][] dist = new int[maps.length][maps[0].length()];

        for (int i = 0; i < maps.length; ++i) {
            for (int j = 0; j < maps[i].length(); ++j) {
                if (maps[i].charAt(j) == 'S') {
                    xQ.add(i);
                    yQ.add(j);
                    visited[i][j] = true;
                }
            }
        }

        char block = 'L';

        while (!xQ.isEmpty() && !yQ.isEmpty()) {
            int x = xQ.poll();
            int y = yQ.poll();
            int nowDist = dist[x][y];

            if (block == 'E' && maps[x].charAt(y) == block) {
                answer = nowDist;
                break;
            }

            if (block == 'L' && maps[x].charAt(y) == block) {
                block = 'E';
                visited = new boolean[maps.length][maps[0].length()];
                xQ.clear();
                yQ.clear();
                visited[x][y] = true;
            }

            for (int i = 0; i < 4; ++i) {
                int nX = x + dx[i];
                int nY = y + dy[i];

                if (nX < 0 || nX >= maps.length || nY < 0 || nY >= maps[0].length()
                        || maps[nX].charAt(nY) == 'X' || visited[nX][nY]) {
                    continue;
                }

                visited[nX][nY] = true;
                dist[nX][nY] = nowDist + 1;
                xQ.add(nX);
                yQ.add(nY);
            }
        }

        return answer;
    }
}
