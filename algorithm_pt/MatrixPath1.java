package algorithm_pt;

public class MatrixPath1 {
	static int[][] m = { { 6, 7, 12, 5 }, 
						 { 5, 3, 11, 18 }, 
						 { 7, 17, 3, 3 },
						 { 8, 10, 14, 9} };
	
	static int matrixPath(int r, int c) {
		if(r == 0 && c == 0) return m[r][c]; // 더이상 이동할 곳이 없으면 현재 위치 값을 리턴함
		else if(r > 0 && c == 0) return m[r][c] + matrixPath(r - 1, c); // 왼쪽으로 이동이 불가능할 경우
		else if(r == 0 && c > 0) return m[r][c] + matrixPath(r, c - 1); // 위쪽으로 이동이 불가을할 경우
		else return m[r][c] + Math.min(matrixPath(r-1, c), matrixPath(r, c-1));
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(matrixPath(3, 3));
	}

}
