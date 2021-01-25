package baekjoon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1120 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		String X = st.nextToken();
		String Y = st.nextToken();

		int min = Integer.MAX_VALUE;
		// Y 문자열의 시작에서 부터 Y 길이에서 X 길이를 뺀 값과 일치하는 인덱스까지 반복한다.
		for (int i = 0; i <= Y.length() - X.length(); ++i) {
			// Y 문자열을 i 위치부터 X 길이 위치까지 자른다.
			String token = Y.substring(i, i + X.length());
			// X문자열과 위에서 자른 문자열을 비교하여 차이 값을 구한다.
			// 차이 값이 min보다 작으면 위의 차이 값으로 min을 갱신한다.
			min = Math.min(min, 차이구하기(X, token));
		}

		// min 값 출력
		System.out.println(min);
	}

	private static int 차이구하기(String a, String b) {
		int 차이 = 0;
		for (int i = 0; i < a.length(); ++i) {
			// 각 위치의 알파벳이 다르면 차이 값을 증가시킴
			if (a.charAt(i) != b.charAt(i))
				++차이;
		}
		return 차이;
	}
}
