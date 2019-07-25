package baekjoon.math;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

// 4153번 직각삼각형 (https://www.acmicpc.net/problem/4153)
public class B4153 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			List<Integer> sides = new ArrayList<>();

			while(st.hasMoreTokens()) {
				sides.add(Integer.parseInt(st.nextToken()));
			}

			if (checkZero(sides)) {
				break;
			}

			sides = sides.stream()
					.sorted(Collections.reverseOrder())
					.collect(Collectors.toList());

			int maxPow = (int) Math.pow(sides.remove(0), 2);
			int otherPow = sides.stream().reduce(0, (a, b) -> a + (int)Math.pow(b, 2));

			System.out.println((maxPow == otherPow) ? "right" : "wrong");
		}
	}

	private static boolean checkZero(List<Integer> sides) {
		return sides.stream().allMatch((a) -> a == 0);
	}
}
