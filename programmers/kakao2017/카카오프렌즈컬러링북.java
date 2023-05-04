package programmers.kakao2017;

import java.util.*;

public class 카카오프렌즈컬러링북 {
	static int[] solution(int m, int n, int[][] picture) {
		int numberOfArea = 0;
		int maxSizeOfOneArea = 0;

		int[] xDistance = {1, -1, 0, 0};
		int[] yDistance = {0, 0, -1, 1};
		boolean[][] visited = new boolean[m][n];

		for (int i = 0; i < m; ++i) {
			for (int j = 0; j < n; ++j) {
				if (!visited[i][j] && picture[i][j] != 0) {
					++numberOfArea;
					int count = 1;

					// bfs로 접근
					Queue<int[]> queue = new LinkedList<>();
					visited[i][j] = true;
					queue.add(new int[] {i, j});

					int x, y;

					while (!queue.isEmpty()) {
						int[] index = queue.remove();

						for (int k = 0; k < xDistance.length; ++k) {
							x = index[0] + xDistance[k];
							y = index[1] + yDistance[k];

							if ((x < m && x >= 0) && (y < n && y >= 0)) {
								if (!visited[x][y] && (picture[x][y] == picture[index[0]][index[1]])) {
									++count;
									visited[x][y] = true;
									queue.add(new int[] {x, y});

								}
							}
						}
					}

					maxSizeOfOneArea = Math.max(maxSizeOfOneArea, count);
				}
			}
		}

		return new int[]{numberOfArea, maxSizeOfOneArea};
	}

	public static void main(String[] args) {
		int m = 6;
		int n = 4;
		int[][] picture = {
				{1, 1, 1, 0},
				{1, 2, 2, 0},
				{1, 0, 0, 1},
				{0, 0, 0, 1},
				{0, 0, 0, 3},
				{0, 0, 0, 3}
		};

		System.out.println(Arrays.toString(solution(m, n, picture)));
	}
}

