package programmers.kakao2020;

import java.util.*;

public class 수식최대화 {
	static long solution(String expression) {
		long answer = 0;
		List<String> list = new LinkedList<>();
		StringBuilder number = new StringBuilder();
		for (int i = 0; i < expression.length(); ++i) {
			char c = expression.charAt(i);
			if (c >= '0' && c <= '9') {
				number.append(c);
				continue;
			}
			list.add(number.toString());
			list.add(String.valueOf(c));
			number = new StringBuilder();
		}
		list.add(number.toString());

		int[][] priority = {
				{0, 1, 2}, {0, 2, 1}, {1, 0, 2},
				{1, 2, 0}, {2, 0, 1}, {2, 1, 0}
		};
		String[] ops = {"*", "+", "-"};

		for (int[] pr : priority) {
			long result = 0;
			List<String> copyList = new LinkedList<>(list);
			for (int p : pr) {
				for (int i = 0; i < copyList.size(); ++i) {
					if (ops[p].equals(copyList.get(i))) {
						long number1 = Long.parseLong(copyList.remove(i - 1));
						String op = copyList.remove(i - 1);
						long number2 = Long.parseLong(copyList.remove(i - 1));
						long calc = calculate(number1, number2, op);
						copyList.add(i - 1, String.valueOf(calc));
						--i;
					}
				}
				result = Math.abs(Long.parseLong(copyList.get(0)));
			}
			answer = Math.max(result, answer);
		}

		return answer;
	}

	private static long calculate(long number1, long number2, String c) {
		if (c.equals("*")) {
			return number1 * number2;
		}
		if (c.equals("+")) {
			return number1 + number2;
		}

		return number1 - number2;
	}

	public static void main(String[] args) {
		String ex = "50*6-3*2";

		System.out.println(solution(ex));
	}
}
