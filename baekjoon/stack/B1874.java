package baekjoon.stack;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/* 1874번 스택 수열
*
* 처음엔 push와 pop을 할 때마다 문자열에 +, -를 추가했는데
* 이렇게 구현하니 메모리 초과가 발생했다.
* BufferedWriter를 사용하여 메모리 문제를 해결했다.
* 출력과정에서 flush와 System.out.print를 섞어서 사용하니 출력초과 문제가 발생했다.
* flush만 사용하도록 수정하니 출력초과 문제가 해결되었다.
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
