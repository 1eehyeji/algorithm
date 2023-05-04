package programmers.level2;

import java.util.PriorityQueue;

// 효율성 테스트 2개 통과 X

public class 더맵게 {
	static int solution(int[] scoville, int K) {
		int answer = 0;

		PriorityQueue<Integer> queue = new PriorityQueue<>();

		for (int i : scoville) {
			queue.offer(i);
		}

		while(queue.peek() <= K) {
			if (queue.size() == 1)
				return -1;

			queue.offer(queue.poll() + (queue.poll() * 2));
			++answer;
		}

		return answer;
	}
	public static void main(String[] args) {
		int[] scoville = {1, 1, 100};
		int K = 7;

		System.out.println(solution(scoville, K));
	}
}
