package baekjoon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 누울 자리를 찾아라
public class B1652 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] room = new int[N][N];

        for (int i = 0; i < N; ++i) {
            String s = br.readLine();
            for (int j = 0; j < N; ++j) {
                room[i][j] = s.charAt(j) == 'X' ? 1 : 0;
            }
        }

        int r = 0;
        int c = 0;

        int rCount = 0;
        int cCount = 0;
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < N; ++j) {
                if (room[i][j] == 0) ++rCount;
                if (room[i][j] == 1 || j == (N - 1)) {
                    if (rCount >= 2) ++r;
                    rCount = 0;
                }

                if (room[j][i] == 0) ++cCount;
                if (room[j][i] == 1 || j == (N - 1)) {
                    if (cCount >= 2) ++c;
                    cCount = 0;
                }
            }
        }

        System.out.println(r + " " + c);
    }
}
