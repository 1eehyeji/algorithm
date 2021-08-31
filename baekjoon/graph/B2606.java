package baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class B2606 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        List<Integer>[] networks = new LinkedList[n];
        for (int i = 0; i < n; ++i) {
            networks[i] = new LinkedList<>();
        }

        for (int i = 0; i < m; ++i) {
            String[] tokens = br.readLine().split(" ");
            networks[Integer.parseInt(tokens[0]) - 1].add(Integer.parseInt(tokens[1]) - 1);
            networks[Integer.parseInt(tokens[1]) - 1].add(Integer.parseInt(tokens[0]) - 1);
        }

        boolean[] isChecked = new boolean[n];
        isChecked[0] = true;

        Queue<Integer> queue = new LinkedList<>(networks[0]);

        int count = 0;

        while (!queue.isEmpty()) {
            if (!isChecked[queue.peek()]) {
                ++count;
                isChecked[queue.peek()] = true;
                queue.addAll(networks[queue.peek()]);
            }
            queue.poll();
        }

        System.out.println(count);
    }
}
