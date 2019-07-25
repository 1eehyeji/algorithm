package baekjoon.array;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

// 3052번 나머지 (https://www.acmicpc.net/problem/3052)
public class B3052 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = 10;
		int N = 42;
		Set<Integer> modSet = new HashSet<>();

		for (int i = 0; i < T; ++i) {
			modSet.add(Integer.parseInt(br.readLine()) % N);
		}

		System.out.println(modSet.size());
	}
}
