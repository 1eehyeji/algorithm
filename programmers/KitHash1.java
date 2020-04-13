package programmers;

import java.util.HashMap;
import java.util.Map;

/*
	프로그래머스 고득점 키트
	해시 - 완주하지 못한 선수
 */
public class KitHash1 {

	public static String solution(String[] participant, String[] completion) {
		String answer = "";
		Map<String, Integer> map = new HashMap<>();

		// hashMap의 get/orDefault 메소드를 사용하여 더 간단하게 구현가능
		// for (String s : participant) { map.put(s, map.getOrDefault(s, 0) + 1); }
		for (String s : participant) {
			Integer i = map.get(s);

			if (i == null) {
				map.put(s, 1);
			} else {
				map.put(s, i + 1);
			}
		}

		for (String s : completion) {
			Integer i = map.get(s);
			map.put(s, i - 1);
		}

		for (String s : map.keySet()) {
			if (map.get(s) > 0) {
				answer = s;
			}
		}

		return answer;
	}

	public static void main(String[] args) {
		String[] p = {"leo", "kiki", "kiki", "eden"};
		String[] c = {"eden", "kiki", "leo"};

		System.out.println(solution(p, c));
	}
}
