package baekjoon.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

// 좌표 압축
public class B18870 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int[] points = new int[N];

        for (int i = 0; i < N; ++i) {
            points[i] = Integer.parseInt(st.nextToken());
        }

        int[] sortedPoints = Arrays.copyOf(points, points.length);
        Arrays.sort(sortedPoints);

        Map<Integer, Integer> map = new HashMap<>();

        for (int sortedPoint : sortedPoints) {
            map.putIfAbsent(sortedPoint, map.size());
        }

        StringBuilder sb = new StringBuilder();

        for (int point : points) {
            sb.append(map.get(point)).append(" ");
        }

        System.out.println(sb.toString().trim());
    }
}
