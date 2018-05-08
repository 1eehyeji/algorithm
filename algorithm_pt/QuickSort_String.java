package algorithm_pt;

import java.util.Arrays;

public class QuickSort_String {

	static int partition(String[] a, int start, int end) {
		String x = a[end]; //기준원소
		int i = start - 1; //1구역의 끝 지점
		
		for(int j = start ; j <= end - 1; ++j ) {
			if(a[j].compareTo(x) < 0)
				swap(a, ++i, j);
		}
		swap(a, i + 1, end);
		return i + 1;
	}
	
	static void swap(String[] a, int i, int j) {
		String temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	static void quickSort(String[] a, int start, int end) {
		if (start >= end) return;
		int middle = partition(a, start, end);
		quickSort(a, start, middle-1);
		quickSort(a, middle+1, end);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub


		String[] a = {"aaa", "bce", "abc", "bcd", "bce", "aaa"};
		
		System.out.println(Arrays.toString(a));
		quickSort(a, 0, a.length-1);
		System.out.println(Arrays.toString(a));
	}

}
