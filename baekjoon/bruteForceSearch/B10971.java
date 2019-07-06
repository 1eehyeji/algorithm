package baekjoon.bruteForceSearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 외판원 순회 2
public class B10971 {

	static int min = Integer.MAX_VALUE;

	public static void permutation(int[][] a, int[] b, int n) { //순열
		if (n == b.length) {
			return;
		}
		for (int i = n; i < b.length; i++) {
			swap(b, i, n);
			permutation(a, b, n + 1);
			solution(a, b);
			swap(b, i, n);
		}
	}

	public static void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	public static void solution(int[][] a, int[] b) {
		int sum = 0;
		for(int i = 0; i <b.length-1; ++i) {
			if(a[b[i]][b[i+1]] == 0) return;
			sum += a[b[i]][b[i+1]];
		}
		if(a[b[b.length-1]][b[0]] == 0) return;
		sum += a[b[b.length-1]][b[0]];
		min = Math.min(sum, min);
		return;
	}

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int[][] a = new int[n][n];
		
		int[] b = new int[n];
		for(int i = 0; i < n; ++i) {
			b[i] = i;
		}
		
		StringTokenizer st;

		for(int i = 0; i < n; ++i) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; ++j) {
				a[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		permutation(a, b, 0);

		System.out.println(min);
	}
}
