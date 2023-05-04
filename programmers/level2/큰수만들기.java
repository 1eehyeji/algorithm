package programmers.level2;

public class 큰수만들기 {
	static String solution(String number, int k) {
		StringBuilder numbers = new StringBuilder(number);
		StringBuilder answer = new StringBuilder();

		while (k != 0) {
			if (k >= numbers.length()) {
				return answer.toString();
			}

			int max = 0;
			int maxIndex = 0;

			for (int i = 0; i < (k + 1); ++i) {
				int num = numbers.charAt(i) - '0';
				if (max < num) {
					max = num;
					maxIndex = i;
				}
			}

			answer.append(max);
			k -= maxIndex;
			numbers.delete(0, (maxIndex + 1));
		}

		answer.append(numbers.toString());

		return answer.toString();
	}

	/*	stack을 사용해서 문제를 해결할 수 있음!
	public String solution(String number, int k) {
		char[] result = new char[number.length() - k];
		Stack<Character> stack = new Stack<>();

		for (int i=0; i<number.length(); i++) {
			char c = number.charAt(i);
			while (!stack.isEmpty() && stack.peek() < c && k-- > 0) {
				stack.pop();
			}
			stack.push(c);
		}
		for (int i=0; i<result.length; i++) {
			result[i] = stack.get(i);
		}
		return new String(result);
	}
	*/

	public static void main(String[] args) {
		String number = "987654321";
		int k = 8;

		System.out.println(solution(number, k));
	}
}
