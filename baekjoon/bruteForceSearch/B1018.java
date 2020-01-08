package baekjoon.bruteForceSearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* 1018번 체스판 다시 칠하기
 *
 * */
public class B1018 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		String[][] board = new String[N][M];

		for (int i = 0; i < N; ++i) {
			String s = br.readLine();
			for (int j = 0; j < M; ++j) {
				board[i][j] = s.substring(j, j + 1);
			}
		}
		br.close();

		int min = Integer.MAX_VALUE;

		for (int i = 0; i <= (N - 8); ++i) {
			for (int j = 0; j <= (M - 8); ++j) {
				String[][] chessBoard = new String[8][8];
				for (int x = 0; x < 8; ++x) {
					for (int y = 0; y < 8; ++y) {
						chessBoard[x][y] = board[i + x][j + y];
					}
				}
				int count = Math.min(changeCount(chessBoard, "B", "W"), changeCount(chessBoard, "W", "B"));

				if (count < min) {
					min = count;
				}
			}
		}

		System.out.println(min);
	}

	private static int changeCount(String[][] chessBoard, String color1, String color2) {
		int count = 0;

		for (int i = 0; i < chessBoard.length; ++i) {
			for (int j = 0; j < chessBoard[i].length; ++j) {
				if (((i % 2) == 0 && (j % 2) == 0) || (i % 2) != 0 && (j % 2) != 0) {
					if (!chessBoard[i][j].equals(color1)) {
						++count;
					}
				} else {
					if (!chessBoard[i][j].equals(color2)) {
						++count;
					}
				}
			}
		}

		return count;
	}
}
