package algorithm_class;

import java.util.Arrays;

public class chap03_01 {

	static void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	static int findMin(int[] a) {
		int min = 0;
		for(int i=1; i<a.length; ++i) {
			if(a[min] > a[i])
				min = i;
		}
		return min;
	}

	static int findMin(int[] a, int start) { //시작 인덱스부터 가장 작은 값을 찾아 인덱스 값을 리턴
		int min = start;
		for(int i = start + 1; i<a.length; ++i) {
			if(a[min] > a[i]) {
				min = i;
			}
		}
		return min;
	}
	public static void main(String[] args) {
		int[] a = {2,4};

		System.out.println(Arrays.toString(a));
		swap(a, 0, 1);
		System.out.println(Arrays.toString(a));

		int[] a1 = { 17, 14, 11, 19 };
		int[] a2 = { -17, -14, -11, -19 };

		int minIndex = findMin(a1);
		System.out.println(a1[minIndex]);

		minIndex = findMin(a2);
		System.out.println(a2[minIndex]);

		int[] a3 = { 14, 11, 13, 15 };

		for (int i = 0; i<a3.length; ++i) {
			int minIndex2 = findMin(a3, i);
			System.out.println(a3[minIndex2]);
		}


	}
}
