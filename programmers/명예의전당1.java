package programmers;

import java.util.PriorityQueue;

public class 명예의전당1 {

    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];

        PriorityQueue<Integer> queue = new PriorityQueue();

        for (int i = 0; i < score.length; ++i) {
            if (queue.size() < k) {
                queue.add(score[i]);
                answer[i] = queue.peek();
                continue;
            }

            if (queue.peek() < score[i]) {
                queue.poll();
                queue.add(score[i]);
            }

            answer[i] = queue.peek();
        }

        return answer;
    }
}
