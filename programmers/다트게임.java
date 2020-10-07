package programmers;

import java.util.*;

public class 다트게임 {
	static int solution(String dartResult) {
		int[] points = new int[4];
		Map<String, Integer> squares = new HashMap<>();

		squares.put("S", 1);
		squares.put("D", 2);
		squares.put("T", 3);

		int index = 0;
		for (int i = 0; i < dartResult.length(); ++i) {
			String s = dartResult.substring(i, i + 1);

			if (s.matches("[0-9]")) {
				++index;
				if (dartResult.substring(i + 1, i + 2).matches("[0-9]")) {
					s = dartResult.substring(i, i + 2);
					++i;
				}
				points[index] = Integer.parseInt(s);
			} else if (s.matches("[A-Z]")) {
				points[index] = (int) Math.pow(points[index], squares.get(s));
			} else {
				if (s.equals("*")) {
					points[index - 1] *= 2;
					points[index] *= 2;
				} else {
					points[index] *= -1;
				}
			}
		}

		return Arrays.stream(points).sum();
	}

	public static void main(String[] args) {
		String s = "10D";

		System.out.println(solution(s));
	}
}
