package algorithm_pt;

public class MatrixChain2 {

	static class Matrix {
		int row, col;
		public Matrix(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}

	static int[][] min;

	static int min(Matrix[] a) {
		min = new int[a.length][a.length];
		for(int d = 1; d < a.length; ++d)
			for(int start = 0; start < a.length - d; ++start) {
				int end = start + d;
				System.out.println( start + " " + end);
				min[start][end] = Integer.MAX_VALUE;
				for(int middle = start; middle < end; ++middle) {
					int count = min[start][middle];
					count += min[middle+1][end];
					count += a[start].row * a[middle].col * a[end].col;
					System.out.println(" " + middle + " " + count);
					if(count < min[start][end]) min[start][end] = count;
				}
			}
		return min[0][a.length-1];
	}

	static void print() {
		for(int i = 0; i < min.length; ++i) {
			for(int j = 0; j < min[i].length; ++j) {
				System.out.print(min[i][j] + "    ");
			}
			System.out.println(" ");
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Matrix[] m = { 
						new Matrix(10, 100), new Matrix(100, 5), new Matrix(5, 50),
						new Matrix(50, 3), new Matrix(3, 8), new Matrix(8,30) 
					}; 
		System.out.println(min(m));
		print();
	}

}
