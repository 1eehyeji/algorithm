package baekjoon.dequeue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

// 요세푸스 문제 0
public class B11866 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split(" ");

        int N = Integer.parseInt(arr[0]);
        int K = Integer.parseInt(arr[1]);

        Deque<Integer> deque = new LinkedList<>();
        for (int i = 1; i <= N; ++i) {
            deque.addLast(i);
        }

        String[] answer = new String[N];
        int index = 0;

        while (!deque.isEmpty()) {
            for (int i = 0; i < (K - 1); ++i) {
                deque.addLast(deque.pollFirst());
            }

            answer[index++] = String.valueOf(deque.pollFirst());
        }

        System.out.println("<" + String.join(", ", answer) + ">");
    }
}
