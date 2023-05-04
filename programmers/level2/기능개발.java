package programmers.level2;

import java.util.*;

public class 기능개발 {
	static int[] solution(int[] progresses, int[] speeds) {
		List<Integer> answer = new ArrayList<>();

		int max = (int) Math.ceil((100.0 - progresses[0]) / speeds[0]);
		int count = 1;

		for (int i = 1; i < progresses.length; ++i) {
			int required = (int) Math.ceil((100.0 - progresses[i]) / speeds[i]);

			if (required > max) {
				max = required;
				answer.add(count);
				count = 1;
			} else {
				++count;
			}
		}

		answer.add(count);

		return answer.stream().mapToInt(i -> i).toArray();
	}
	public static void main(String[] args) {
		int[] progresses = {93, 30, 55};
		int[] speeds = {1, 30, 5};

		System.out.println(Arrays.toString(solution(progresses, speeds)));
	}
}
