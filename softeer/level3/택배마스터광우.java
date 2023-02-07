package softeer.level3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class 택배마스터광우 {

    static List<int[]> railSequenceList;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] railWeights = new int[N];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; ++i) {
            railWeights[i] = Integer.parseInt(st.nextToken());
        }

        railSequenceList = new ArrayList();

        for (int i = 0; i < N; ++i) {
            bfs(N, railWeights, new boolean[N], i, new int[N], 0);
        }

        int minWeight = Integer.MAX_VALUE;

        for (int[] sequence : railSequenceList) {
            minWeight = Math.min(minWeight, getTotalWeight(N, M, K, sequence));
        }

        System.out.println(minWeight);

        br.close();
    }

    public static void bfs(int N, int[] railWeights, boolean[] visited, int index, int[] sequence, int sequenceIndex) {
        visited[index] = true;
        sequence[sequenceIndex] = railWeights[index];

        if (sequenceIndex == (N - 1)) {
            railSequenceList.add(Arrays.copyOf(sequence, N));
            return;
        }

        for (int i = 0; i < N; ++i) {
            if (visited[i]) continue;

            bfs(N, railWeights, visited, i, sequence, sequenceIndex + 1);
            visited[i] = false;
        }
    }

    public static int getTotalWeight(int N, int M, int K, int[] weights) {
        int totalWeight = 0;
        int rail = 0;

        while (K-- > 0) {
            int weight = 0;

            while ((weight + weights[rail]) <= M) {
                weight += weights[rail];
                rail = (rail + 1) % N;
            }

            totalWeight += weight;
        }

        return totalWeight;
    }
}
