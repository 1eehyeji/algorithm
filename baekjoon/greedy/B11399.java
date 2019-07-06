package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// ATM
public class B11399 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int[] p = new int[n];
		for(int i = 0; i < n; ++i)
			p[i] = Integer.parseInt(st.nextToken());

		Arrays.sort(p); // 오름차순으로 정렬하는 경우가 걸리는 시간의 최솟값임

		int sum = 0; // 각 사람이 돈을 인출하는데 필요한 시간
		int time = 0; // 각 사람이 돈을 인출하는데 필요한 시간의 합
		for(int i : p) {
			sum = sum + i;
			time += sum;
		}

		System.out.println(time);
	}

}
