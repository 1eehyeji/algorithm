package programmers;

// 이상한 문자 만들기
public class WeirdString {
	public static String solution(String s) {
		StringBuilder sb = new StringBuilder();
		char[] alphabet = s.toCharArray();

		int count = 0;
		for (int i = 0; i < alphabet.length; ++i) {
			if (alphabet[i] != ' ') {
				sb.append((count % 2) == 0 ? Character.toUpperCase(alphabet[i]) : Character.toLowerCase(alphabet[i]));
				++count;
			} else {
				sb.append(" ");
				count = 0;
			}
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		String s = "try hello world";

		System.out.println(solution(s));
	}
}
