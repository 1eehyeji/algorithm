package baekjoon.queue;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

// 큐2
public class B18258 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        Deque<Integer> queue = new LinkedList<>();

        while (N-- > 0) {
            String[] command = br.readLine().trim().split(" ");

            switch (command[0]) {
                case "push":
                    queue.add(Integer.parseInt(command[1]));
                    break;
                case "pop":
                    sb.append(queue.isEmpty() ? -1 : queue.pollFirst()).append("\n");
                    break;
                case "size":
                    sb.append(queue.size()).append("\n");
                    break;
                case "empty":
                    sb.append(queue.isEmpty() ? 1 : 0).append("\n");
                    break;
                case "front":
                    sb.append(queue.isEmpty() ? -1 : queue.peekFirst()).append("\n");
                    break;
                case "back":
                    sb.append(queue.isEmpty() ? -1 : queue.peekLast()).append("\n");
                    break;
            }
        }

        br.close();
        System.out.println(sb.toString());
    }
}
