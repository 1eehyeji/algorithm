package programmers;

/*
 * 행렬릐 덧셈은 행과 열의 크기가 같은 두 행렬의 같은 행,
 * 같은 열의 값을 서로 더한 결과가 됩니다.
 * 2개의 행렬을 입력받는 sumMatrix 함수를 완성하여
 * 행렬 덧셈의 결과를 반환해 주세요.
 */

class SumMatrix {
	int[][] sumMatrix(int[][] A, int[][] B) {
		int[][] answer = {{0, 0}, {0, 0}};
		answer = new int[A.length][A[0].length];
		for(int i = 0; i < answer.length; ++i) {
			for(int j = 0; j < answer[i].length; ++j) {
				answer[i][j] = A[i][j] + B[i][j];
			}
		}
		return answer;
	}

	// 아래는 테스트로 출력해 보기 위한 코드입니다.
	public static void main(String[] args) {
		SumMatrix c = new SumMatrix();
		int[][] A = { { 1, 2, 3 }, { 2, 3, 4 }, { 3, 4, 5 } };
		int[][] B = { { 3, 4, 5 }, { 5, 6, 7 }, { 6, 7, 8 } };
		int[][] answer = c.sumMatrix(A, B);
		for(int i = 0; i < answer.length; ++i) {
			for(int j = 0; j < answer[i].length; ++j) {
				System.out.print(" " + answer[i][j] + " ");
			}
			System.out.println();
		}
		if (answer[0][0] == 4 && answer[0][1] == 6 && 
				answer[1][0] == 7 && answer[1][1] == 9) {
			System.out.println("맞았습니다. 제출을 눌러 보세요");
		} else {
			System.out.println("틀렸습니다. 수정하는게 좋겠어요");
		}
	}
}
