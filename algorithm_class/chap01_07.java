package algorithm_class;

import java.util.Random;

//시간복잡도 O(n^2)
public class chap01_07 {
	
	static void print(int[] a) {
		for(int i : a) {
			System.out.printf("%d ", i);
		}
	}
	
	static void sort(int[] a) {
		for(int i = 0; i<a.length; ++i) {
			for(int j = i + 1; j<a.length; ++j) {
				if(a[i] > a[j]) {
					swap(a, i, j);
				}
			}
		}
	}

	static void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Random random = new Random();
		int[] a = new int[10];
		
		for(int i = 0; i<a.length; ++i) {
			a[i] = random.nextInt(20);
		}
		
		sort(a);
		print(a);
	}

}
