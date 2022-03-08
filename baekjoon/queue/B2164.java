package baekjoon.queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.stream.IntStream;

// 카드2
public class B2164 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        br.close();

        Deque<Integer> card = new LinkedList<>();
        IntStream.range(1, N + 1).boxed().forEach(card::add);

        while (card.size() > 1) {
            card.pollFirst();
            card.addLast(card.pollFirst());
        }

        System.out.println(card.peek());
    }
}
