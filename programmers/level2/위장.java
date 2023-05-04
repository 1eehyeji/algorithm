package programmers.level2;

import java.util.HashMap;
import java.util.Map;

public class 위장 {
	static int solution(String[][] clothes) {
		int answer = 1;

		Map<String, Integer> clothesMap = new HashMap<>();

		for (String[] s : clothes) {
			clothesMap.put(s[1], clothesMap.getOrDefault(s[0], 0) + 1);
		}

		for (String s : clothesMap.keySet()) {
			answer *= (clothesMap.get(s) + 1);
		}

		return answer - 1;
	}

	public static void main(String[] args) {

	}
}
