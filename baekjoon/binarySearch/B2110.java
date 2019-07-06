package baekjoon.binarySearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B2110 {

	static int solution(long[] a, long mid) {
		int count = 1;
		long now = a[0];
		for(int i = 0; i < a.length; ++i) {
			if(a[i] - now >= mid) {
				++count;
				now = a[i];
			}
		}
		return count;
	}

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken()); // 집의 개수
		int m = Integer.parseInt(st.nextToken()); // 공유기 개수

		long[] a = new long[n];
		for(int i = 0; i < n; ++i) {
			a[i] = Long.valueOf(br.readLine());
		}

		Arrays.parallelSort(a);

		long min = 1;
		long max = a[n-1] - a[0];
		long result = 1;
		while(min <= max) {
			long mid = (min + max) / 2;
			if(solution(a, mid) >= m) {
				result = Math.max(result, mid);
				min = mid + 1;
			}
			else {
				max = mid - 1;
			}
		}

		System.out.println(result);
	}

}
