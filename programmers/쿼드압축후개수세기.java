package programmers;

import java.util.Arrays;

public class 쿼드압축후개수세기 {

	static int[] answer = new int[2];

	static boolean check(int[][] a, int i, int j, int n) {	// 같은 값으로만 이루어져있는지 검사
		for(int x = i; x < i+n; ++x) {
			for(int y = j; y < j+n; ++y) {
				if(a[i][j] != a[x][y])
					return false;
			}
		}
		return true;
	}

	static void divide(int[][] a, int i, int j, int n) {
		if(check(a, i, j, n)) {
			++answer[a[i][j]];	// 같은 값으로만 이루어져 있으면 그 값을 출력(n이 1인 경우 포함)
			return;
		}

		int m = n/2;	// 영상을 4개의 부분으로 나눔

		for(int x = 0; x < 2; ++x) {
			for(int y = 0; y < 2; ++y) {
				divide(a, i+x*m, j+y*m, m);	// 총 4번의 재귀함수가 호출됨
			}
		}
	}

	static int[] solution(int[][] arr) {
		divide(arr, 0, 0, arr.length);

		return answer;
	}

	public static void main(String[] args) {
		int[][] arr = {
				{1, 1, 0, 0},
				{1, 0, 0, 0},
				{1, 0, 0, 1},
				{1, 1, 1, 1}
		};

		System.out.println(Arrays.toString(solution(arr)));
	}
}
