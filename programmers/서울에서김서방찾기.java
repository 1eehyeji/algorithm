package programmers;

public class 서울에서김서방찾기 {
	static String solution(String[] seoul) {
		String name = "Kim";

		int index = 0;
		for (; index < seoul.length; ++index) {
			if (seoul[index].equals(name)) {
				break;
			}
		}

		return "김서방은 " + index + "에 있다";
	}
}
