package baekjoon.bruteForceSearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 차이를 최대로
public class B10819 {
	
	static int max = Integer.MIN_VALUE;

	public static void permutation(int[] a, int n) { //순열
		if (n == a.length) {
			return;
		}
		for (int i = n; i < a.length; i++) {
			swap(a, i, n);
			permutation(a, n + 1);
			solution(a);
			swap(a, i, n);
		}
	}
	
	public static void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	public static void solution(int[] a) {
		int sum = 0;
		for(int i = 0; i <a.length-1; ++i) {
			sum += Math.abs(a[i] - a[i+1]);
		}
		max = Math.max(sum, max);
		return;
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] a = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < n; ++i) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		
		permutation(a, 0);
		
		System.out.println(max);
	}

}
