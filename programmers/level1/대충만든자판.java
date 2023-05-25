package programmers.level1;

import java.util.HashMap;
import java.util.Map;

public class 대충만든자판 {

    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];

        Map<String, Integer> keyIndexMap = new HashMap<>();

        for (String keys : keymap) {
            for (int i = 0; i < keys.length(); ++i) {
                String key = String.valueOf(keys.charAt(i));

                int minIndex = Math.min(keyIndexMap.getOrDefault(key, Integer.MAX_VALUE), i + 1);
                keyIndexMap.put(key, minIndex);
            }
        }

        for (int i = 0; i < targets.length; ++i) {
            String target = targets[i];
            int pushCount = 0;
            for (int j = 0; j < target.length(); ++j) {
                String key = String.valueOf(target.charAt(j));
                if (!keyIndexMap.containsKey(key)) {
                    pushCount = -1;
                    break;
                }
                pushCount += keyIndexMap.get(key);
            }
            answer[i] = pushCount;
        }

        return answer;
    }
}
