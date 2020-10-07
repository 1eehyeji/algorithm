package programmers;

public class 비밀지도 {
	static String[] solution(int n, int[] arr1, int[] arr2) {
		String[] answer = new String[n];
		String format = "%0" + n + "d";
		StringBuilder sb;

		for (int i = 0; i < n; ++i) {
			String a1 = String.format(format, binaryStringToLong(arr1[i]));
			String a2 = String.format(format, binaryStringToLong(arr2[i]));

			sb = new StringBuilder();
			for (int j = 0; j < n; ++j) {
				int num1 = a1.charAt(j) - '0';
				int num2 = a2.charAt(j) - '0';

				sb.append((num1 | num2) == 1 ? "#" : " ");
			}

			answer[i] = sb.toString();
		}

		return answer;
	}

	static long binaryStringToLong(int num) {
		return Long.parseLong(Integer.toBinaryString(num));
	}

	public static void main(String[] args) {

	}
}
