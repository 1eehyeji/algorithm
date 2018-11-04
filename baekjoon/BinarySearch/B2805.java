package baekjoon.BinarySearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 나무 자르기
// 절단기 높이가 높아질 수록 나무 길이는 짧아짐
public class B2805 {

	// 절단기의 높이가 mid일 때 잘린 나무의 길이를 리턴
	static long solution(long[] a, long mid) {
		long length = 0;
		for(int i = 0; i < a.length; ++i) {
			if(a[i] > mid)
				length += a[i] - mid;
		}
		return length;
	}

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken()); // 나무의 개수
		long m = Long.valueOf(st.nextToken()); // 가져가야할 최소 나무 길이

		long[] a = new long[n];
		st = new StringTokenizer(br.readLine());
		long min = 0;
		long max = 0;
		for(int i = 0; i < n; ++i) {
			a[i] = Long.valueOf(st.nextToken());
			if(a[i] > max)
				max = a[i];
		}

		long result = 0;
		while(min <= max) {
			long mid = (min + max) / 2;
			if(solution(a, mid) >= m) {	// 잘린 나무의 길이가 m이상인 경우 절단기를 높임
				result = Math.max(result, mid);
				min = mid + 1;
			}
			else {				// m미만인 경우 절단기를 낮춤
				max = mid - 1;
			}
		}

		System.out.println(result);
	}

}
