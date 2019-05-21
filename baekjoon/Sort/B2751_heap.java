package baekjoon.Sort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class B2751_heap {

	public static void heapSort(int[] a) {
		buildHeap(a);

		for (int i = a.length - 1; i > 0; --i) {
			swap(a, 0, i);
			heapify(a, 0, i - 1);
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());

		int[] a = new int[n];

		while(n --> 0) {
			a[n] = Integer.parseInt(br.readLine());
		}

		heapSort(a);

		for (int i = a.length - 1; i >= 0; --i) {
			bw.write(String.valueOf(a[i]));
			bw.newLine();
		}

		bw.flush();

		bw.close();
		br.close();
	}

	public static void buildHeap(int[] a) {
		int end = a.length - 1;
		for (int i = end / 2; i >= 0; --i) {
			heapify(a, i, end);
		}
	}

	public static void heapify(int[] a, int start, int end) {
		int leftChild = (2 * start) + 1;    // 배열의 인덱스가 0부터 시작하기 때문
		int rightChild = (2 * start) + 2;

		int smaller;
		if (rightChild <= end) {
			smaller = a[leftChild] < a[rightChild] ? leftChild : rightChild;
		} else if (leftChild <= end) {
			smaller = leftChild;
		} else {
			return;
		}

		if (a[smaller] < a[start]) {
			swap(a, smaller, start);
			heapify(a, smaller, end);
		}
	}

	public static void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
}
