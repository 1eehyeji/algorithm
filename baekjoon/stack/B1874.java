package baekjoon.stack;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/* 1874번 스택 수열
* */
public class B1874 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		int[] sequence = new int[N];
		Stack<Integer> stack = new Stack<>();
		List<String> answer = new ArrayList<>();

		for (int i = 0; i < N; ++i) {
			sequence[i] = Integer.parseInt(br.readLine());
		}

		int index = 0;

		for (int i = 1; i <= N; ++i) {
			stack.push(i);
			answer.add("+");

			while (!stack.empty() && stack.peek() == sequence[index]) {
				stack.pop();
				++index;
				answer.add("-");
			}
		}

		if (stack.empty()) {
			for (String s : answer) {
				bw.write(s);
				bw.newLine();
			}
		} else {
			bw.write("NO");
		}

		bw.flush();
		bw.close();
		br.close();
	}
}
