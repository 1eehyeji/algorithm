package algorithm_pt;

import java.util.Arrays;

public class PersonTest {

	static int partition(Person[] a, int start, int end) {
		Person x = a[end]; //기준원소
		int i = start - 1; //1구역의 끝 지점
		
		for(int j = start ; j <= end - 1; ++j ) {
			if(a[j].compareTo(x) < 0)
				swap(a, ++i, j);
		}
		swap(a, i + 1, end);
		return i + 1;
	}
	
	static void swap(Person[] a, int i, int j) {
		Person temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	static void quickSort(Person[] a, int start, int end) {
		if (start >= end) return;
		int middle = partition(a, start, end);
		quickSort(a, start, middle-1);
		quickSort(a, middle+1, end);
	}
	
	static void mergeSort(Person[] a, int start, int end) {
		if(start == end) return;
		if(start < end) {
			int middle = (start + end) / 2;
			mergeSort(a, start, middle);
			mergeSort(a, middle + 1, end);
			merge(a, start, middle, end);
		}
	}
	static void merge(Person[] a, int start, int middle, int end) {
		int length = end - start + 1;
		Person[] temp = new Person[length];
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

		Person[] p1 = new Person[] {
				new Person("가나", 18),
				new Person("가가", 22),
				new Person("가나", 23)
		};
		
		Person[] p2 = new Person[] {
				new Person("가나", 18),
				new Person("가가", 22),
				new Person("가나", 23)
		};
		
		mergeSort(p1, 0, p1.length - 1);
		System.out.println(Arrays.toString(p1));
		
		quickSort(p2, 0, p2.length - 1);
		System.out.println(Arrays.toString(p2));
	}

}
