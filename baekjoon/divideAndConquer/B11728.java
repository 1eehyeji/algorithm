package baekjoon.divideAndConquer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 배열 합치기
public class B11728 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[] a = new int[n+m];

		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; ++i)
			a[i] = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		for(int i = n; i < m+n; ++i)
			a[i] = Integer.parseInt(st.nextToken());

		Arrays.sort(a);

		for(int i : a)
			System.out.print(i + " ");
	}

}
