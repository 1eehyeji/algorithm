package baekjoon.bruteForceSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;

// 10974번 모든 순열
public class B10974 {

    public static void permutation(int depth, boolean[] visited, int n, int[] nums) {
        if (depth == n) {
            String s = Arrays.stream(nums)
                    .mapToObj(String::valueOf)
                    .collect(Collectors.joining(" "));

            System.out.println(s);
        }

        for (int i = 1; i <= n; ++i) {
            if (visited[i]) continue;

            nums[depth] = i;
            visited[i] = true;
            permutation(depth + 1, visited, n, nums);

            visited[i] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        permutation(0, new boolean[n + 1], n, new int[n]);
    }
}
