package baekjoon.divideAndConquer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1517 {
	static int[] a;
	static long count = 0;

	static void sort(int start, int end) {
		if(start >= end) {
			return;
		}
		int mid = (start + end) / 2;
		sort(start, mid);
		sort(mid + 1, end);
		merge(start, end);
	}

	static void merge(int start, int end) {
		int[] b = new int[end-start+1];
		int mid = (start + end) / 2;
		int i = start;
		int j = mid + 1;
		int x = 0;

		while(i <= mid && j <= end) {
			if(a[i] > a[j]) {
				b[x] = a[j];
				++x;
				++j;
				count += mid - i + 1;	// 왼쪽에 남은 값만큼 카운트에 더한다
			}
			else {
				b[x] = a[i];
				++x;
				++i;
			}
		}

		while(i <= mid) {
			b[x] = a[i];
			++x;
			++i;
		}
		while(j <= end) {
			b[x] = a[j];
			++x;
			++j;
		}
		for(int y = start; y <= end; ++y) {
			a[y] = b[y-start];
		}
	}

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());

		a = new int[n];

		for(int i = 0; i < n; ++i) {
			a[i] = Integer.parseInt(st.nextToken());
		}

		sort(0, n-1);

		System.out.println(count);
	}

}
