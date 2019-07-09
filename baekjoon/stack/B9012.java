package baekjoon.stack;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class B9012 {
	static String solution(String s) {
		Stack<Character> stack = new Stack<>();

		for (char c : s.toCharArray()) {
			if (c == '(') {
				stack.push(c);

			} else if (c == ')') {

				if (!stack.empty()) {
					stack.pop();
				} else {
					return "NO";
				}
			}
		}

		if (!stack.empty()) {
			return "NO";
		}

		return "YES";
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; ++i) {
			String s = br.readLine();

			bw.write(solution(s));
			bw.newLine();
		}

		bw.flush();
		bw.close();
		br.close();
	}
}
