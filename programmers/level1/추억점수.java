package programmers.level1;

import java.util.HashMap;
import java.util.Map;

public class 추억점수 {

    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];

        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < name.length; ++i) {
            map.put(name[i], yearning[i]);
        }

        for (int i = 0; i < photo.length; ++i) {
            String[] peoples = photo[i];
            int point = 0;
            for (String people : peoples) {
                point += map.getOrDefault(people, 0);
            }
            answer[i] = point;
        }

        return answer;
    }
}
