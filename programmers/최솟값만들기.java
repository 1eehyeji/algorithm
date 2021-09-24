package programmers;

import java.util.Comparator;
import java.util.PriorityQueue;

public class 최솟값만들기 {

    public static int solution(int[] A, int[] B) {
        int answer = 0;

        PriorityQueue<Integer> queue1 = new PriorityQueue<>();
        PriorityQueue<Integer> queue2 = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i < A.length; ++i) {
            queue1.add(A[i]);
            queue2.add(B[i]);
        }

        for (int i = 0; i < A.length; ++i) {
            answer += (queue1.poll() * queue2.poll());
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] A = {1, 2};
        int[] B = {3, 4};

        System.out.println(solution(A, B));
    }
}
