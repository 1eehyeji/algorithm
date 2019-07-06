package baekjoon.sort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class B2751_merge {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());

		int[] array = new int[n];

		for (int i = 0; i < n; ++i) {
			array[i] = Integer.parseInt(br.readLine());
		}

		mergeSort(array, 0, array.length - 1);

		for (int i : array) {
			bw.write(String.valueOf(i));
			bw.newLine();
		}

		bw.flush();

		bw.close();
		br.close();
	}

	public static void mergeSort(int[] array, int start, int end) {
		if (start >= end) {
			return;
		}

		int middle = (start + end) / 2;

		mergeSort(array, start, middle);
		mergeSort(array, middle + 1, end);
		merge(array, start, middle, end);
	}

	public static void merge(int[] array, int start, int middle, int end) {
		int s = start;
		int m = middle + 1;

		int i = 0;

		int[] a = new int[(end - start) + 1];

		while (s <= middle && m <= end) {
			if (array[s] < array[m]) {
				a[i] = array[s];
				++i;
				++s;
			} else {
				a[i] = array[m];
				++i;
				++m;
			}
		}

		while (s <= middle) {
			a[i] = array[s];
			++i;
			++s;
		}

		while (m <= end) {
			a[i] = array[m];
			++i;
			++m;
		}

		for (int j = 0; j < a.length; ++j) {
			array[start + j] = a[j];
		}

	}
}
