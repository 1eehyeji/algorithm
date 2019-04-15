package baekjoon.String;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/* 백준 2675번 문자열 반복
* 문자열 S를 입력받은 후에, 각 문자를 R번 반복해 새 문자열 P를 만든 후 출력하는 프로그램을 작성하시오.
* 첫째 줄에 테스트 케이스의 개수 T(1 ≤ T ≤ 1,000)가 주어진다.
* 각 테스트 케이스는 반복 횟수 R(1 ≤ R ≤ 8), 문자열 S가 공백으로 구분되어 주어진다.
* S의 길이는 적어도 1이며, 20글자를 넘지 않는다.
 * */
public class B2675_2 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int R = 0;
		String S = "";
		char[] c;

		while (T --> 0) {
			st = new StringTokenizer(br.readLine());

			R = Integer.parseInt(st.nextToken());
			S = st.nextToken();

			for(int i = 0; i < S.length(); ++i) {
				// String클래스의 repeat메소드를 대신 사용가능(java 11부터)
				// 백준에서는 컴파일 에러 발생함
				c = new char[R];
				Arrays.fill(c, S.charAt(i));
				sb.append(new String(c));
			}
			sb.append("\n");
		}

		System.out.println(sb.toString());

	}
}
