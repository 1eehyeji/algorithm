package programmers.level2;

public class 점프와순간이동 {

	static int solution(int n) {
		int answer = 0;

		for (char c : Integer.toBinaryString(n).toCharArray()) {
			if (c == '1') {
				++answer;
			}
		}

		return answer;
	}
	public static void main(String[] args) {

	}
}
