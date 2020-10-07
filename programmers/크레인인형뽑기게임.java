package programmers;

import java.util.Stack;

public class 크레인인형뽑기게임 {
	static int solution(int[][] board, int[] moves) {
		Stack<Integer> stack = new Stack<>();
		int count = 0;

		for (int i : moves) {
			for (int j = 0; j < board.length; ++j) {
				if (board[j][i - 1] != 0) {
					int now = board[j][i - 1];
					if (!stack.isEmpty() && stack.peek() == now) {
						count += 2;
						stack.pop();
					} else {
						stack.push(now);
					}
					board[j][i - 1] = 0;
					break;
				}
			}
		}

		return count;
	}

	public static void main(String[] args) {
		int[][] board = {
				{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}
		};

		int[] moves = {1, 5, 3, 5, 1, 2, 1, 4};

		System.out.println(solution(board, moves));
	}
}
