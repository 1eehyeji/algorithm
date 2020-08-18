package programmers;

//문자열을 숫자로 바꾸는 문제
public class StringToInt {
	public static int solution(String s) {
		boolean negative = false;
		int i = 0;

		if (s.substring(0, 1).matches("[-+]")) {	// 맨 앞에 부호가 오는 경우
			negative = s.charAt(0) == '-';				// 음수 부호이면 true 값이 저장됨
			++i;
		}

		int answer = s.charAt(i) - 48;					// 숫자를 정수로 바꾸는 과정

		for (i += 1; i < s.length(); ++i) {
			answer = (answer * 10) + (s.charAt(i) - 48);
		}

		return negative ? -answer : answer;
	}
	public static void main(String[] args) {
		String s = "1234";
		String s1 = "-1234";

		System.out.println(solution(s));
		System.out.println(solution(s1));
	}

}
