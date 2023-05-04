package programmers.level1;

public class 시저암호 {
	private String solution(String s, int n) {
		StringBuilder sb = new StringBuilder();

		for (char c : s.toCharArray()) {
			if (c == ' ') {
				sb.append(c);
				continue;
			}

			char caesar = (char) (c + n);

			if (c > 'Z') {
				caesar = caesar > 'z' ? (char)(caesar - 26) : caesar;
			} else {
				caesar = caesar > 'Z' ? (char)(caesar - 26) : caesar;
			}

			sb.append(caesar);
		}

		return sb.toString();
	}
}
