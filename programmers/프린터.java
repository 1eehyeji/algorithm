package programmers;

import java.util.*;
import java.util.stream.Collectors;

public class 프린터 {
	static int solution(int[] priorities, int location) {
		int answer = 0;

		Queue<Document> orders = new LinkedList<>();

		for (int i = 0; i < priorities.length; ++i) {
			orders.add(new Document(i, priorities[i]));
		}

		List<Integer> priorityList = Arrays.stream(priorities).boxed()
				.sorted(Collections.reverseOrder())
				.collect(Collectors.toList());

		int count = 0;
		while (orders.size() != 0) {
			Document document = orders.poll();

			if (priorityList.get(0) == document.priority) {    // 현재 문서의 우선순위가 가장 큰 경우 -> 인쇄
				priorityList.remove(0);
				++count;

				if (location == document.index) {    // 궁금한 문서가 인쇄된 경우 -> 인쇄된 순서를 출력
					answer = count;
					break;
				}

			} else {    // 우선순위가 가장 크지 않은 경우 -> 큐의 맨 뒤로 보냄
				orders.add(document);
			}
		}

		return answer;
	}

	static class Document {

		int index;    // 문서의 처음 index

		int priority;    // 우선 순위

		public Document(int index, int priority) {
			this.index = index;
			this.priority = priority;
		}
	}

	public static void main(String[] args) {
		int[] priorities = {2, 1, 3, 2};
		int location = 2;

		System.out.println(solution(priorities, location));
	}
}
