package programmers.level2;

import java.util.HashSet;
import java.util.Set;

public class 영어끝말잇기 {
	public int[] solution(int n, String[] words) {
		int[] answer = {0, 0};
		Set<String> set = new HashSet<>();
		int[] persons = new int[n];

		// 첫번째 순서 처리
		set.add(words[0]);
		int personNum = 1;
		++persons[0];

		for (int i = 1; i < words.length; ++i) {
			++persons[personNum];

			String pre = words[i - 1];
			char preLastChar = pre.charAt(pre.length() - 1);
			if (set.contains(words[i]) || preLastChar != words[i].charAt(0)) {
				return new int[]{personNum + 1, persons[personNum]};
			}

			set.add(words[i]);
			personNum = (personNum + 1) % n;
		}

		return answer;
	}
}
