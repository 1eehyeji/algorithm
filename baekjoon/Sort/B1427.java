package baekjoon.Sort;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 백준 1427번 소트인사이드
*
* 배열을 정렬하는 것은 쉽다. 수가 주어지면, 그 수의 각 자리수를 내림차순으로 정렬해보자.
*
* 첫째 줄에 정렬하고자하는 수 N이 주어진다. N은 1,000,000,000보다 작거나 같은 자연수이다.
* */
public class B1427 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		br.close();

		List<Integer> list = new ArrayList<>();

		while (N > 0) {    // 숫자 분리
			int n = N % 10;
			list.add(n);
			N /= 10;
		}

		list.stream().sorted((x, y) -> y - x)  // 내림차순 정렬
				.forEach(System.out::print);   // 출력
	}
}
