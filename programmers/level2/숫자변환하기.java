package programmers.level2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.IntStream;

public class 숫자변환하기 {

    public static int solution(int x, int y, int n) {
        int[] dp = new int[y + 1];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(x);

        while (!queue.isEmpty()) {
            int num = queue.poll();

            if (num == y) {
                return dp[num];
            }

            for (int i : IntStream.of((num + n), (num * 2), (num * 3)).toArray()) {
                if (i > y || dp[i] > 0) continue;

                dp[i] = dp[num] + 1;
                queue.add(i);
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(solution(2, 5 , 4));
    }
}