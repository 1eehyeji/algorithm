package programmers;

public class 문자열내p와y의개수 {
	static boolean solution(String s) {
		int count = 0;

		s = s.toLowerCase();

		for (char c : s.toCharArray()) {
			switch (c) {
				case 'p':
					count++;
					break;
				case 'y':
					count--;
					break;
			}
		}

		return count == 0;
	}
	public static void main(String[] args) {
		String s = "pPoooyY";

		System.out.println(solution(s));
	}
}
