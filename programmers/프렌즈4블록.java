package programmers;

import java.util.*;

public class 프렌즈4블록 {
	static int solution(int m, int n, String[] board) {
		int answer = 0;

		char[][] blocks = new char[n][m];
		int index = m - 1;

		for (int j = 0; j < m; ++j) {
			for (int i = 0; i < n; ++i) {
				blocks[i][j] = board[index].charAt(i);
			}
			--index;
		}

		while (true) {
			Set<Point> removedBlocks = getFourBlocksPoints(blocks);
			answer += removedBlocks.size();
			blocks = removeBlocks(removedBlocks, blocks);

			if (removedBlocks.size() == 0) {
				break;
			}
		}
		return answer;
	}

	private static char[][] removeBlocks(Set<Point> points, char[][] blocks) {
		for (Point point : points) {
			blocks[point.x][point.y] = ' ';
		}

		String[] newBoard = new String[blocks.length];

		for (int i = 0; i < blocks.length; ++i) {
			newBoard[i] = String.valueOf(blocks[i]).replaceAll(" ", "");
		}

		blocks = fillBlocks(blocks.length, blocks[0].length, newBoard);

		return blocks;
	}

	private static char[][] fillBlocks(int n, int m, String[] newBoard) {
		char[][] blocks = new char[n][m];

		for (int i = 0; i < n; ++i) {
			StringBuilder sb = new StringBuilder(newBoard[i]);

			for (int j = 0; j < m - newBoard[i].length(); ++j) {
				sb.append(" ");
			}

			blocks[i] = sb.toString().toCharArray();
		}

		return blocks;
	}

	private static Set<Point> getFourBlocksPoints(char[][] blocks) {
		Set<Point> points = new HashSet<>();

		for (int i = 0; i < blocks.length; ++i) {
			for (int j = 0; j < blocks[i].length; ++j) {
				if (blocks[i][j] == ' ')
					continue;

				Point right = new Point(i, j + 1);
				Point bottom = new Point(i + 1, j);
				Point diagonal = new Point(i + 1, j + 1);

				if (((i + 1) >= blocks.length) || ((j + 1) >= blocks[i].length)) {
					continue;
				}

				int[] values = {
						blocks[i][j], blocks[right.x][right.y],
						blocks[bottom.x][bottom.y], blocks[diagonal.x][diagonal.y]
				};

				if (isEqualsAll(values)) {
					points.add(new Point(i, j));
					points.add(right);
					points.add(bottom);
					points.add(diagonal);
				}
			}
		}

		return points;
	}

	private static boolean isEqualsAll(int[] values) {
		int value = values[0];

		for (int i = 1; i < values.length; ++i) {
			if (value != values[i])
				return false;
		}

		return true;
	}

	static void printMatrix(char[][] blocks) {
		for (char[] block : blocks) {
			for (int j = 0; j < block.length; ++j) {
				System.out.print(block[j]);
			}

			System.out.println();
		}

		System.out.println("-----------");
	}

	static class Point {
		int x;
		int y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public int hashCode() {
			int i = (this.x + this.y);
			return Integer.hashCode(i);
		}

		@Override
		public boolean equals(Object obj) {
			if (obj instanceof Point) {
				Point p = (Point) obj;
				return (this.x == p.x) && (this.y == p.y);
			}
			return false;
		}
	}

	public static void main(String[] args) {
		int m = 6;
		int n = 6;
		String[] board = {
				"TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"
		};

		System.out.println(solution(m, n, board));
	}
}
