package programmers.level1;

import java.util.HashSet;
import java.util.Set;

public class 폰켓몬 {
	static int solution(int[] nums) {
		int pickCount = nums.length / 2;

		Set<Integer> kinds = new HashSet<>();
		for (int num : nums) {
			kinds.add(num);
		}

		return Math.min(pickCount, kinds.size());
	}

	public static void main(String[] args) {
	}
}
