package codility;

import java.util.Arrays;

public class CyclicRotation {

	static int[] solution(int[] a, int K) {
		//배열의 크기가 0, 1일 때 받아온 배열 그대로 리턴
		if(a.length < 2) return a;
		
		// 한 칸씩 주어진 K번 만큼 이동
		for(int i = 0; i < K; ++i ) {
			int n = a[a.length - 1];
			for(int j = a.length - 1; j > 0; --j) {
				a[j] = a[j-1];
			}
			a[0] = n;
		}
		return a;
		
	/* 매개변수로 받은 배열에서 K번 이동한 인덱스를 구하여
	 * 새로운 배열의 해당 인덱스에 값을 복사
		int[] a2 = new int[a.length];
		
		for(int i = 0; i < a.length; ++i) {
			int idx = (i + K) % a.length;
			a2[idx] = a[i];
		}
		
		return a2;
	*/
	}
	
	public static void main(String[] args) {
		
		int[] a = { 3, 8, 9, 7, 6 };
		
		int k = 4;
		
		System.out.println(Arrays.toString(solution(a,k)));
	}

}
