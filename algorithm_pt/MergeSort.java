package algorithm_pt;

import java.util.Arrays;

public class MergeSort {

	static void mergeSort(int[] a, int start, int end) {
		if(start == end) return;
		if(start < end) {
			int middle = (start + end) / 2;
			mergeSort(a, start, middle);
			mergeSort(a, middle + 1, end);
			merge(a, start, middle, end);
		}
	}
	static void merge(int[] a, int start, int middle, int end) {
		int length = end - start + 1;
		int[] temp = new int[length];
		int i = 0;
		int idx1 = start;
		int idx2 = middle + 1;

		while(idx1 <= middle && idx2 <= end) {
			if(a[idx1] < a[idx2])
				temp[i++] = a[idx1++];
			else
				temp[i++] = a[idx2++];
		}
		while(idx1 <= middle)
			temp[i++] = a[idx1++];
		while(idx2 <= end)
			temp[i++] = a[idx2++];
		for(i = 0; i < temp.length; ++i)
			a[start + i] = temp[i];

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] a1 = { 8, 7, 6, 5, 4, 3, 2, 1};
		mergeSort(a1, 0, a1.length - 1);
		System.out.println(Arrays.toString(a1));

		int[] a2 = { 2, 1, 6, 8, 3, 5, 4, 7};
		mergeSort(a2, 0, a2.length - 1);
		System.out.println(Arrays.toString(a2));
	}

}
