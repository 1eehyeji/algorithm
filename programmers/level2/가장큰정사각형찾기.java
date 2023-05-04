package programmers.level2;

public class 가장큰정사각형찾기 {
	static int solution(int[][] board) {
		if (board.length == 1 || board[0].length == 1) {
			return 1;
		}

		int maxValue = 0;
		for (int i = 1; i < board.length; ++i) {
			for (int j = 1; j < board[0].length; ++j) {
				if (board[i][j] != 0) {
					board[i][j] = Math.min(board[i - 1][j],
							Math.min(board[i][j - 1], board[i - 1][j - 1])) + 1;
					maxValue = Math.max(maxValue, board[i][j]);
				}
			}
		}

		return maxValue * maxValue;
	}

	public static void main(String[] args) {
		int[][] board = {
			{0, 0, 1, 1},
			{1, 1, 1, 1}
		};

		System.out.println(solution(board));
	}
}
