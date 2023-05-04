package programmers.level1;

import java.util.*;

public class 제일작은수제거하기 {
	private int[] solution(int[] arr) {
		int min = Integer.MAX_VALUE;

		for (int i : arr) {
			min = Math.min(min, i);
		}

		List<Integer> list = new ArrayList<>();

		for (int i : arr) {
			if (i != min) {
				list.add(i);
			}
		}

		return list.size() > 0 ? list.stream().mapToInt(i -> i).toArray() : new int[] {-1};
	}
}
