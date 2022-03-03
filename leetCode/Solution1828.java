package leetCode;

// Queries on Number of Points Inside a Circle
public class Solution1828 {

    public static int[] countPoints(int[][] points, int[][] queries) {
        int[] answer = new int[queries.length];

        for (int[] point : points) {
            int x1 = point[0];
            int y1 = point[1];
            for (int i = 0; i < queries.length; ++i) {
                int x2 = queries[i][0];
                int y2 = queries[i][1];
                int r = queries[i][2];

                if (Math.pow(r, 2) >= (Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2))) {
                    ++answer[i];
                }
            }
        }

        return answer;
    }
}
