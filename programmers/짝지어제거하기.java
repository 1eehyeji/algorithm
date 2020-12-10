package programmers;

import java.util.Stack;

public class 짝지어제거하기 {
	public int solution(String s) {
		Stack<Character> stack = new Stack<>();
		for (char c : s.toCharArray()) {
			if (!stack.isEmpty() && stack.peek() == c) {
				stack.pop();
				continue;
			}
			stack.push(c);
		}

		return stack.isEmpty() ? 1 : 0;
	}
}
