package baekjoon.DivideAndConquer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 숫자카드 binarySearch 메소드 사용하여 구현
public class B10815 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		int[] a = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; ++i) {
			a[i] = Integer.parseInt(st.nextToken());
		}

		int m = Integer.parseInt(br.readLine());
		int[] b = new int[m];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < m; ++i) {
			b[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(a);
		StringBuilder builder = new StringBuilder();

		for(int i : b) {
			if(Arrays.binarySearch(a, i) >= 0)
				builder.append("1 ");
			else
				builder.append("0 ");
		}

		System.out.println(builder.toString());
	}

}
