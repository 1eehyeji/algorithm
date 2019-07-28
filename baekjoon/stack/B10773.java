package baekjoon.stack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

// 백준 10773번 제로 (https://www.acmicpc.net/problem/10773)
public class B10773 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int K = Integer.parseInt(br.readLine());

		Stack<Integer> stack = new Stack<>();

		while (K --> 0) {
			int n = Integer.parseInt(br.readLine());

			if (n != 0) {
				stack.push(n);
			} else {
				if (stack.isEmpty()) {
					continue;
				}

				stack.pop();
			}
		}

		int sum = stack.stream().reduce(0, (a, b) -> a + b);

		System.out.println(sum);
	}
}
