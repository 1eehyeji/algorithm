package programmers;

import java.util.*;

public class 뒤집어배열로만들기 {
	public int[] solution(long n) {
		List<Integer> answer = new ArrayList<>();

		while(n > 0) {
			answer.add((int)(n % 10));
			n /= 10;
		}

		return answer.stream().mapToInt(i -> i).toArray();
	}
}
