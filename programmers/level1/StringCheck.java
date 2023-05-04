package programmers.level1;

/* 문자열 다루기 기본
*
* 문자열을 int로 변환해주는 메소드를 사용하여 구현
* 문자열에 숫자가 아닌 문자가 섞여있는 경우 NumberFormatException이 발생하고,
* try catch문을 사용하여 Exception이 발생한 경우 false를 return 하도록 구현함
* 문자열의 길이가 4 또는 6이 아닌 경우 Exception을 발생시켜 위와 동일하게 처리함
*/
public class StringCheck {
	public static boolean solution(String s) {
		boolean answer = true;

		try {
			if (s.length() != 4 && s.length() != 6)
				throw new Exception();				// Exception을 발생시킴

			int number = Integer.parseInt(s); 		// 문자열을 int형으로 변환하는 메소드
		} catch (Exception e) {						// Exception이 발생하면 잡아서 처리함
			answer = false;
		}

		return answer;
	}

	public static void main(String[] args) {
	}
}
