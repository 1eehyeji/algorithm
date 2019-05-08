package codingTest.N0413;

public class Test1 {

	static int[][] dice = {
			{0, 1, 1, 1, 1, 2},
			{1, 0, 1, 1, 2, 1},
			{1, 1, 0, 2, 1, 1},
			{1, 1, 2, 0, 1, 1,},
			{1, 2, 1, 1, 0, 1},
			{2, 1, 1, 1, 1, 0}
	};

	public static void solution(int[] a) {
		int min = Integer.MAX_VALUE;

		if(a.length == 1) {
			System.out.println(0);
			return;
		}

		for(int i = 0; i < a.length; ++i) {
			int num = a[i];
			int sum = 0;
			for(int j = 0; j < a.length; ++j) {
				sum += dice[a[j]-1][num-1];
			}
			if(sum < min) {
				min = sum;
			}
		}

		System.out.println(min);
	}

	public static void main(String[] args) {
		int[] A1 = { 1, 2, 3};
		int[] A2 = { 1, 1, 6};
		int[] A3  = { 1, 6, 2, 3};

		solution(A1);
		solution(A2);
		solution(A3);

	}

}