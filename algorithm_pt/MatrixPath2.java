package algorithm_pt;

public class MatrixPath2 {
	static int[][] m = { { 6, 7, 12, 5 }, 
			{ 5, 3, 11, 18 }, 
			{ 7, 17, 3, 3 },
			{ 8, 10, 14, 9} };
	
	static int[][] a = new int[4][4];	// 동적 프로그래밍 적용

	static int matrixPath(int r, int c) {
		System.out.println(r + ", " + c);

		if(a[r][c] != 0) return a[r][c];

		if (r == 0 && c == 0) // 더이상 이동할 곳이 없으면 현재 위치 값을 리턴함
			a[r][c] = m[r][c];
		else if (r > 0 && c == 0)
			a[r][c] = m[r][c] + matrixPath(r - 1, c); // 왼쪽으로 이동이 불가능할 경우
		else if (r == 0 && c > 0)
			a[r][c] = m[r][c] + matrixPath(r, c - 1); // 위쪽으로 이동이 불가을할 경우		
		else 
			a[r][c] = m[r][c] + Math.min(matrixPath(r-1, c), matrixPath(r, c-1));
		return a[r][c];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(matrixPath(3, 3));
	}

}
