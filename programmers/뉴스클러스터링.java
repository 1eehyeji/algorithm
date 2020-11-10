package programmers;

import java.util.*;

public class 뉴스클러스터링 {
	static int solution(String str1, String str2) {
		int answer = 65536;

		Map<String, Integer> str1Tokens = getTokens(str1.toLowerCase());
		Map<String, Integer> str2Tokens = getTokens(str2.toLowerCase());

		float intersectionSize = 0;
		float unionSize = 0;

		for (String key : str1Tokens.keySet()) {
			Integer count1 = str2Tokens.get(key);
			Integer count2 = str1Tokens.get(key);

			if (count1 == null) {
				unionSize += count2;
			} else {
				intersectionSize += Math.min(count1, count2);
				unionSize += Math.max(count1, count2);
				str2Tokens.remove(key);
			}
		}

		for (String key : str2Tokens.keySet()) {
			unionSize += str2Tokens.get(key);
		}

		if (unionSize != 0) {
			answer *= (intersectionSize / unionSize);
		}

		return answer;
	}

	private static Map<String, Integer> getTokens(String str) {
		Map<String, Integer> tokens = new HashMap<>();

		for (int i = 0; i < (str.length() - 1); ++i) {
			String token = str.substring(i, i + 2);

			if (token.matches("[a-z]+")) {
				tokens.put(token, tokens.getOrDefault(token, 0) + 1);
			}
		}

		return tokens;
	}

	public static void main(String[] args) {
		String str1 = "FRANCE";
		String str2 = "french";

		System.out.println(solution(str1, str2));
	}
}
