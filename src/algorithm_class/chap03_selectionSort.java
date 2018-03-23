package algorithm_class;

import java.util.Arrays;

public class chap03_selectionSort {

	static void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	static int findMin(int[] a, int start) {
		int min = start;
		for(int i = start + 1; i < a.length; ++i) {
			if(a[min] > a[i]) {
				min = i;
			}
		}
		return min;
	}
	
	static void selectionSort(int[] a) {
		for(int i = 0; i < a.length - 2; ++i) {
			int minIdx = findMin(a, i);
			swap(a, i, minIdx);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] a = { 17, 14, 11, 19, 13, 15, 18, 12, 16, 20};
		
		selectionSort(a);
		System.out.println(Arrays.toString(a));
	}

}
