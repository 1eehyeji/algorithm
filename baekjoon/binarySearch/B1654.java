package baekjoon.binarySearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B1654 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		int n = Integer.parseInt(s[0]); // 가지고 있는 랜선 개수
		int k = Integer.parseInt(s[1]);	// 필요한 랜선 개수

		long[] a = new long[n];
		long max = 0;
		for(int i = 0; i < n; ++i) {
			a[i] = Long.parseLong(br.readLine());
			max = Math.max(max, a[i]);
		}

		long min = 1;
		long middle = 0;
		while(min <= max) {
			middle = (min + max) / 2;

			long count = 0;
			for(int i = 0; i < n; ++i) {
				count += a[i] / middle;
			}

			if(count >= k) {
				min = middle + 1;
			}
			else if(count < k) {
				max = middle - 1;
			}
		}

		System.out.println(max);
	}

}
