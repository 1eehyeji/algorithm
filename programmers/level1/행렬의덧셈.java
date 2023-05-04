package programmers.level1;

public class 행렬의덧셈 {
	private int[][] solution(int[][] arr1, int[][] arr2) {
		int[][] arr = new int[arr1.length][arr1[0].length]; // @1
		for(int i=0; i<arr1.length; i++) { // @2
			for(int j=0; j<arr1[0].length; j++) { // @3
				arr[i][j] = arr1[i][j] + arr2[i][j]; // @4
			}
		}
		return arr;
	}
}
