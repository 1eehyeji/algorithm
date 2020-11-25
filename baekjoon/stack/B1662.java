package baekjoon.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class B1662 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		br.close();

		Stack<String> stack = new Stack<>();

		for (int i = 0; i < s.length(); ++i) {
			if (s.charAt(i) == ')') {
				int count = 0;
				while (!stack.isEmpty()) {
					String str = stack.pop();
					if (str.equals("(")) {
						break;
					}
					if (str.equals("*")) {
						count += Integer.parseInt(stack.pop());
						continue;
					}
					++count;
				}
				stack.push(String.valueOf(count * Integer.parseInt(stack.pop())));
				stack.push("*");
				continue;
			}

			stack.add(String.valueOf(s.charAt(i)));
		}

		int answer = 0;
		while(!stack.isEmpty()) {
			String str = stack.pop();
			if (str.equals("*")) {
				answer += Integer.parseInt(stack.pop());
				continue;
			}
			++answer;
		}

		System.out.println(answer);
	}
}
