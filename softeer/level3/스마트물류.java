package softeer.level3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 스마트물류 {

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] tokens = br.readLine().split(" ");
        int N = Integer.parseInt(tokens[0]);
        int K = Integer.parseInt(tokens[1]);

        String position = br.readLine();
        boolean[] isRemained = new boolean[N];
        Arrays.fill(isRemained, true);

        int count = 0;

        for (int i = 0; i < N; ++i) {
            char c = position.charAt(i);

            if (c == 'H') continue;

            // 로봇인 경우
            for (int j = i - K; j <= (i + K); ++j) {
                if (j >= N) break;
                if (j < 0 || position.charAt(j) == 'P') continue;

                if (isRemained[j]) {
                    ++count;
                    isRemained[j] = false;
                    break;
                }
            }
        }

        System.out.println(count);

        br.close();
    }
}
