package baekjoon.array;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;
import java.util.StringTokenizer;

/* 백준 1158번 조세퍼스 문제
 *
 * List 를 사용하고, 이동할 위치 값을 계산하여 문제해결
 */
public class B1158 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		List<Integer> list = new ArrayList<>();

		for(int i = 1; i <= N; ++i) {
			list.add(i);
		}

		StringJoiner sj = new StringJoiner(", ");

		int index = 0;

		while (list.size() > 0) {
			index = (index + K - 1) % list.size();
			sj.add(list.remove(index).toString());
		}

		System.out.println("<" + sj + ">");
	}
}
