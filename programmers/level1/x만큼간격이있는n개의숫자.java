package programmers.level1;

import java.util.*;

public class x만큼간격이있는n개의숫자 {
	private long[] solution(int x, int n) {
		List<Long> answer = new ArrayList<>();

		long num = 0;
		while (n --> 0) {
			answer.add((long)(num += x));
		}

		return answer.stream().mapToLong(i -> i).toArray();
	}
}
