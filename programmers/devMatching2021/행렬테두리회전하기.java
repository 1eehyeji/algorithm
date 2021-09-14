package programmers.devMatching2021;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class 행렬테두리회전하기 {

    public static int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        int k = 0;

        int[][] matrix = new int[rows][columns];
        int index = 1;
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < columns; ++j) {
                matrix[i][j] = index++;
            }
        }

        for (int[] query : queries) {
            int x1 = query[0];
            int y1 = query[1];
            int x2 = query[2];
            int y2 = query[3];

            int x = x1 - 1;
            int y = y1 - 1;

            Deque<Integer> q = new LinkedList<>();
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < (y2 - y1); ++i) {
                min = Math.min(min, matrix[x][y]);
                q.add(matrix[x][y++]);
            }
            for (int i = 0; i < (x2 - x1); ++i) {
                min = Math.min(min, matrix[x][y]);
                q.add(matrix[x++][y]);
            }
            for (int i = 0; i < (y2 - y1); ++i) {
                min = Math.min(min, matrix[x][y]);
                q.add(matrix[x][y--]);
            }
            for (int i = 0; i < (x2 - x1); ++i) {
                min = Math.min(min, matrix[x][y]);
                q.add(matrix[x--][y]);
            }

            q.addFirst(q.pollLast());
            answer[k++] = min;

            x = x1 - 1;
            y = y1 - 1;
            for (int i = 0; i < (y2 - y1); ++i) {
                matrix[x][y++] = q.pollFirst();
            }
            for (int i = 0; i < (x2 - x1); ++i) {
                matrix[x++][y] = q.pollFirst();
            }
            for (int i = 0; i < (y2 - y1); ++i) {
                matrix[x][y--] = q.pollFirst();
            }
            for (int i = 0; i < (x2 - x1); ++i) {
                matrix[x--][y] = q.pollFirst();
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int rows = 6;
        int columns = 6;
        int[][] queries = {
                {2, 2, 5, 4},
                {3, 3, 6, 6},
                {5, 1, 6, 3}
        };

        System.out.println(Arrays.toString(solution(rows, columns, queries)));
    }
}
