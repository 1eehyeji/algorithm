package programmers;

import java.util.*;

public class 구명보트 {
	static int solution(int[] people, int limit) {
		int answer = 0;

		Arrays.parallelSort(people);

		LinkedList<Integer> peoples = new LinkedList();
		for (int i : people) {
			peoples.add(i);
		}

		while (peoples.size() > 1) {
			if ((peoples.get(0) + peoples.get(peoples.size() - 1)) <= limit) {
				++answer;
				peoples.removeFirst();
				peoples.removeLast();
			} else {
				++answer;
				peoples.removeLast();
			}
		}

		return answer + peoples.size();
	}

	public static void main(String[] args) {
		int[] people = {70, 50, 80};

		System.out.println(solution(people, 100));
	}
}
