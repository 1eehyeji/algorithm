package algorithm_pt;

import java.util.Arrays;

public class MergeSort_String {

	static void mergeSort(String[] a, int start, int end) {
		if(start == end) return;
		if(start < end) {
			int middle = (start + end) / 2;
			mergeSort(a, start, middle);
			mergeSort(a, middle + 1, end);
			merge(a, start, middle, end);
		}
	}
	static void merge(String[] a, int start, int middle, int end) {
		int length = end - start + 1;
		String[] temp = new String[length];
		int i = 0;
		int idx1 = start;
		int idx2 = middle + 1;
		
		while(idx1 <= middle && idx2 <= end) {
			if(a[idx1].compareTo(a[idx2]) < 0)
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

		String[] a1 = { "a", "f", "c", "b", "e", "d"};
		mergeSort(a1, 0, a1.length - 1);
		System.out.println(Arrays.toString(a1));
		
		String[] a2 = {"abc", "aaa", "acc", "acb"};
		mergeSort(a2, 0, a2.length - 1);
		System.out.println(Arrays.toString(a2));
	}

}
