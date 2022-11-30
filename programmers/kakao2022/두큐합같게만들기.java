package programmers.kakao2022;

import java.util.LinkedList;
import java.util.Queue;

public class 두큐합같게만들기 {

    public static int solution(int[] queue1, int[] queue2) {
        int answer = 0;

        Queue<Integer> q1 = new LinkedList();
        Queue<Integer> q2 = new LinkedList();
        long totalOfq1 = 0;
        long totalOfq2 = 0;

        for (int i : queue1) {
            q1.add(i);
            totalOfq1 += i;
        }

        for (int i : queue2) {
            q2.add(i);
            totalOfq2 += i;
        }

        if ((totalOfq1 + totalOfq2) % 2 != 0) return -1;

        int maxMoveCount = (queue1.length * 2) + 1;

        while (totalOfq1 != totalOfq2) {
            if (answer > maxMoveCount ) return -1;

            if (totalOfq1 < totalOfq2) {
                int n = q2.poll();
                q1.add(n);
                totalOfq1 += n;
                totalOfq2 -= n;
                ++answer;
                continue;
            }

            int n = q1.poll();
            q2.add(n);
            totalOfq2 += n;
            totalOfq1 -= n;
            ++answer;
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] queue1 = {1, 2, 1, 2};
        int[] queue2 = {1, 10, 1, 2};

        System.out.println(solution(queue1, queue2));
    }
}
