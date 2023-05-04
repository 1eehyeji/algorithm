package programmers.level2;

public class JadenCase문자열만들기 {
	public String solution(String s) {
		char[] chars = s.toLowerCase().toCharArray();

		if (Character.isAlphabetic(chars[0])) {
			chars[0] = toUpperCase(chars[0]);
		}

		for (int i = 1; i < chars.length; ++i) {
			char c = chars[i];

			if (chars[i - 1] == ' ' && Character.isAlphabetic(c)) {
				chars[i] = toUpperCase(c);
			}
		}

		return String.valueOf(chars);
	}

	static char toUpperCase(char c) {
		return (char)(c - 32);
	}
}
