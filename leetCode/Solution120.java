package leetCode;

import java.util.Arrays;
import java.util.List;

// Triangle
public class Solution120 {

    public static int minimumTotal(List<List<Integer>> triangle) {
        int rowLength = triangle.size();

        int[][] dp = new int[rowLength][triangle.get(rowLength - 1).size()];

        dp[0][0] = triangle.get(0).get(0);

        for (int i = 1; i < rowLength; ++i) {
            int colLength = triangle.get(i).size();

            for (int j = 0; j < colLength; ++j) {
                int now = triangle.get(i).get(j);

                if (j == 0) {
                    dp[i][j] = dp[i - 1][j] + now;
                    continue;
                }

                if (j == colLength - 1) {
                    dp[i][j] = dp[i - 1][j - 1] + now;
                    continue;
                }

                dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j - 1]) + now;
            }
        }

        return Arrays.stream(dp[dp.length - 1]).min().getAsInt();
    }
}
