package programmers.level2;

import java.util.*;

public class 귤고르기 {

    public int solution(int k, int[] tangerine) {
        int answer = 0;

        Map<Integer, Integer> tangerineCountMap = new HashMap<>();

        for (int i : tangerine) {
            tangerineCountMap.put(i, tangerineCountMap.getOrDefault(i, 0) + 1);
        }

        List<Integer> tangerineCountList = new ArrayList<>(tangerineCountMap.values());
        Collections.sort(tangerineCountList, Collections.reverseOrder());
        int sum = 0;

        for (int count : tangerineCountList) {
            if (sum < k) {
                ++answer;
                sum += count;
            }
        }

        return answer;
    }
}
