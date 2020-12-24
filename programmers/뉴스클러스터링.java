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
			Integer tokenCount1 = str1Tokens.get(key);
			Integer tokenCount2 = str2Tokens.get(key);

			if (tokenCount2 == null) {                               				// str1Tokens에만 존재하는 값을 합집합에 포함시킴
				unionSize += tokenCount1;
			} else {
				intersectionSize += Math.min(tokenCount1, tokenCount2);   			// 동일한 토큰을 가지면 교집합에 더 적은 토큰 개수를 더함
				unionSize += Math.max(tokenCount1, tokenCount2);          			//            ``             더 많은 토큰 개수를 더함
				str2Tokens.remove(key);                         					// 처리한 토큰은 삭제 (str1Tokens에는 없는 값만 남기기 위해)
			}
		}

		for (String key : str2Tokens.keySet()) {                					// str2Tokens에만 존재하는 값을 합집합에 포함시킴
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

			if (token.matches("[a-z]+")) {                              		// 알파벳으로만 이루어진 토큰인지 확인
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
