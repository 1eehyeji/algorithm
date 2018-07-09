package algorithm_pt;

public class MatrixChain1 {
	
	static int[][] arr;
	
	static int minMulti(Matrix[] m, int start, int end) {
		if(arr == null) arr = new int[m.length][m.length]; //동적 프로그래밍을 위한 배열
		if(arr[start][end] != 0) return arr[start][end];
		if(start == end) return 0;
		
		int min = Integer.MAX_VALUE;
		
		for(int middle = start; middle < end; ++middle) {
			int count = minMulti(m, start, middle);
			count += minMulti(m, middle+1, end);
			count += m[start].row * m[middle].col * m[end].col;
			if(min > count) {
				min = count;
				arr[end][start] = middle;
			}
		}
		return arr[start][end] = min;
	}
	
	static int maxMulti(Matrix[] m, int start, int end) {
		if(start == end) return 0;
		
		int max = Integer.MIN_VALUE;
		for(int middle = start; middle < end; ++middle) {
			int count = maxMulti(m, start, middle);
			count += maxMulti(m, middle+1, end);
			count += m[start].row * m[middle].col * m[end].col;
			if(max < count) max = count;
		}
		return max;
	}
	
	static void print() {
		for(int i = 0; i < arr.length; ++i) {
			for(int j = 0; j < arr[i].length; ++j) {
				System.out.print(arr[i][j] + "    ");
			}
			System.out.println(" ");
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Matrix[] m = { new Matrix(10, 100), new Matrix(100, 5), new Matrix(5, 50),
						new Matrix(50, 3), new Matrix(3, 8), new Matrix(8,30) };
		
		System.out.println(minMulti(m, 0 ,m.length-1));
		System.out.println(maxMulti(m, 0 ,m.length-1));
		
		print();
	}

}

class Matrix{
	int row, col;
	
	public Matrix(int r, int c) {
		row = r;
		col = c;
	}
}