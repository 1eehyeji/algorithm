package programmers.level1;

import java.util.Arrays;

public class 정수내림차순으로배치하기 {
	private long solution(long n) {
		String s = String.valueOf(n);
		char[] chars = s.toCharArray();

		Arrays.sort(chars);

		StringBuilder sb = new StringBuilder(String.valueOf(chars));

		return Long.parseLong(sb.reverse().toString());
	}
}
