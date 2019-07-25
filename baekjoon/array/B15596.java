package baekjoon.array;

// 15596번 정수 N개의 합 (https://www.acmicpc.net/problem/15596)
public class B15596 {

	public long sum(int[] a) {
		long sum = 0;

		for (int i : a) {
			sum += i;
		}

		return sum;
	}
}
