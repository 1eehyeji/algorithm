package algorithm_pt;

import java.util.Arrays;
import java.util.Random;

public class QuickSort {

	static int partition(int[] a, int start, int end) {
		int x = a[end]; //기준원소
		int i = start - 1; //1구역의 끝 지점
		
		for(int j = start ; j <= end - 1; ++j ) {
			if(a[j] < x)
				swap(a, ++i, j);
		}
		swap(a, i + 1, end);
		return i + 1;
	}
	
	static void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	static void quickSort(int[] a, int start, int end) {
		if (start >= end) return;
		int middle = partition(a, start, end);
		quickSort(a, start, middle-1);
		quickSort(a, middle+1, end);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Random random = new Random();
		int[] a = new int[10];
		
		for (int i = 0; i < a.length; ++i)
			a[i] = random.nextInt(20);
		
		System.out.println(Arrays.toString(a));
		quickSort(a, 0, a.length-1);
		System.out.println(Arrays.toString(a));
	}

}
