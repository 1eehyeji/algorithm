package programmers.level2;

import java.util.Stack;

public class 올바른괄호 {
	static boolean solution(String s) {
		Stack<Character> stack = new Stack<>();

		for (int i = 0; i < s.length(); ++i) {
			char c = s.charAt(i);

			if (c == '(') {
				stack.push('(');
			} else {
				if (stack.isEmpty())
					return false;
				stack.pop();
			}
		}

		return stack.isEmpty();
	}
}
