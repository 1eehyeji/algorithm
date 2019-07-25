package baekjoon.math;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

// 1085번 직사각형에서 탈출 (https://www.acmicpc.net/problem/1085)
public class B1085 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());

		List<Integer> distances = new ArrayList<>();

		distances.add(x);
		distances.add(y);
		distances.add(w - x);
		distances.add(h - y);

		distances = distances.stream().sorted().collect(Collectors.toList());

		System.out.println(distances.get(0));
	}
}
