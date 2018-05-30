package programmers;

//문자열을 숫자로 바꾸는 문제
public class StringToInt {
	public static int solution(String s) {
		int answer = Integer.parseInt(s);
		return answer;
	}
	public static void main(String[] args) {
		String s = "1234";
		String s1 = "-1234";

		System.out.println(solution(s));
		System.out.println(solution(s1));
	}

}
