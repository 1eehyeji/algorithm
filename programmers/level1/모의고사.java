package programmers.level1;

import java.util.*;

public class 모의고사 {
	static int[] solution(int[] answers) {
		List<Integer> answer = new ArrayList<>();

		int[] number1 = {1, 2, 3, 4, 5};
		int[] number2 = {2, 1, 2, 3, 2, 4, 2, 5};
		int[] number3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

		int[] counts = new int[3];

		for (int i = 0; i < answers.length; ++i) {
			if (number1[i % number1.length] == answers[i])
				++counts[0];
			if (number2[i % number2.length] == answers[i])
				++counts[1];
			if (number3[i % number3.length] == answers[i])
				++counts[2];
		}

		int max = Math.max(counts[0], Math.max(counts[1], counts[2]));

		for (int i = 0; i < counts.length; ++i) {
			if (counts[i] == max)
				answer.add(i + 1);
		}

		return answer.stream().mapToInt(i -> i).toArray();
	}
	public static void main(String[] args) {
		int[] answers = {4, 4, 4};

		System.out.println(Arrays.toString(solution(answers)));
	}
}
