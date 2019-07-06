package baekjoon.sort;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

/* 백준 1181번 단어 정렬
*
* 알파벳 소문자로 이루어진 N개의 단어가 들어오면 아래와 같은 조건에 따라 정렬하는 프로그램을 작성하시오.
* 1. 길이가 짧은 것부터
* 2. 길이가 같으면 사전 순으로
*
* 첫째 줄에 단어의 개수 N이 주어진다. (1≤N≤20,000)
* 둘째 줄부터 N개의 줄에 걸쳐 알파벳 소문자로 이루어진 단어가 한 줄에 하나씩 주어진다.
* 주어지는 문자열의 길이는 50을 넘지 않는다.
* 단, 같은 단어가 여러 번 입력된 경우에는 한 번씩만 출력한다.
 * */
public class B1181 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		Set<String> words = new HashSet<>();  // 중복되는 단어 처리

		while (N-- > 0) {
			words.add(br.readLine());
		}

		words.stream().sorted((s1, s2) -> {   // 길이가 작은 순서대로, 길이가 같은 경우 사전 순
			if (s1.length() == s2.length()) {
				return s1.compareTo(s2);
			}
			return s1.length() - s2.length();
		}).forEach(System.out::println);
	}
}
