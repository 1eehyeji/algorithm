package programmers;

import java.util.*;

public class 튜플 {
	static int[] solution(String s) {
		String tupleString = s.substring(2, s.length() - 2);
		List<String> tokens = Arrays.asList(tupleString.split("\\},\\{"));
		tokens.sort(Comparator.comparingInt(String::length));

		Set<String> set = new LinkedHashSet<>();
		for (String token : tokens) {
			set.addAll(Arrays.asList(token.split(",")));
		}

		int[] answer = new int[set.size()];
		int i = 0;
		for (String element : set) {
			answer[i++] = Integer.parseInt(element);
		}

		return answer;
	}

	public static void main(String[] args) {
		String s = "{{1,2,3},{2,1},{1,2,4,3},{2}}";

		System.out.println(Arrays.toString(solution(s)));
	}
}
