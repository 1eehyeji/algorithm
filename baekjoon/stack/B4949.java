package baekjoon.stack;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

// 4949번 균형잡힌 세상 (https://www.acmicpc.net/problem/4949)
public class B4949 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String s;

		while (!(s = br.readLine()).equals(".")) {
			if (isBalanced(s)) {
				bw.write("yes\n");
			} else {
				bw.write("no\n");
			}
		}

		br.close();

		bw.flush();
		bw.close();
	}

	public static boolean isBalanced(String s) {
		Stack<Character> stack = new Stack<>();

		for (char c : s.toCharArray()) {
			if (c == '(' || c =='[') {
				stack.push(c);
			} else if (c == ')' || c == ']') {

				if (stack.isEmpty()) {
					return false;
				}

				char pre = stack.peek();

				if ((c == ')' && pre == '(') || (c == ']' && pre == '[')) {
					stack.pop();
				} else {
					return false;
				}
			}
		}

		return stack.isEmpty();
	}
}
