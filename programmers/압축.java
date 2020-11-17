package programmers;

import java.util.*;

public class 압축 {
	static int[] solution(String msg) {
		List<Integer> output = new ArrayList<>();

		Map<String, Integer> tokens = new HashMap<>();
		for (int i = 65; i < 91; ++i) {
			tokens.put(String.valueOf((char) i), (i - 'A') + 1);
		}

		int index = 0;
		int maxValue = tokens.get("Z");
		for (int j = index + 1; j < msg.length(); ++j) {
			if (!tokens.containsKey(msg.substring(index, j + 1))) {
				output.add(tokens.get(msg.substring(index, j)));
				tokens.put(msg.substring(index, j + 1), ++maxValue);
				index = j;
			}
		}

		output.add(tokens.get(msg.substring(index)));

		int[] answer = new int[output.size()];
		for (int i = 0; i < output.size(); ++i) {
			answer[i] = output.get(i);
		}

		return answer;
	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution("KAKAO")));
	}
}
