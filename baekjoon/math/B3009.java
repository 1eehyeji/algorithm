package baekjoon.math;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 3009번 네 번째 점 (https://www.acmicpc.net/problem/3009)
public class B3009 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = 3;

		List<Integer> x = new ArrayList<>();
		List<Integer> y = new ArrayList<>();

		while(T --> 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			Integer newX = Integer.parseInt(st.nextToken());
			Integer newY = Integer.parseInt(st.nextToken());

			addList(x, newX);
			addList(y, newY);
		}

		System.out.println(x.get(0) + " " + y.get(0));
	}

	private static void addList(List<Integer> list, Integer value) {
		if (list.contains(value)) {
			list.remove(value);
		} else {
			list.add(value);
		}
	}
}
