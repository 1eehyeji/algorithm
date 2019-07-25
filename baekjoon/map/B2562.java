package baekjoon.map;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

// 2562번 최댓값 (https://www.acmicpc.net/problem/2562)
public class B2562 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		Map<Integer, Integer> numbers = new HashMap<>();

		for (int i = 1; i < 10; ++i) {
			numbers.put(Integer.parseInt(br.readLine()), i);
		}

		int maxKey = numbers.keySet().stream().max(Integer::compareTo).get();
		int value = numbers.get(maxKey);

		System.out.print(maxKey + "\n" + value);
	}
}
