package programmers.kakao2022;

import java.util.HashMap;
import java.util.Map;

public class 성격유형검사하기 {

    public String solution(String[] survey, int[] choices) {
        StringBuilder answer = new StringBuilder();

        String[] personalityTypes = {"RT", "CF", "JM", "AN"};

        int[] points = {3, 2, 1, 0, 1, 2, 3};

        Map<Character, Integer> scoreOfType = new HashMap<>();

        for (int i = 0; i < survey.length; ++i) {
            int choice = choices[i];

            if (choice == 4) continue;

            char type = survey[i].charAt((choice < 4) ? 0 : 1);

            scoreOfType.put(type, scoreOfType.getOrDefault(type, 0) + points[choice - 1]);
        }

        for (String type : personalityTypes) {
            if (scoreOfType.getOrDefault(type.charAt(0), 0) >= scoreOfType.getOrDefault(type.charAt(1), 0)) {
                answer.append(type.charAt(0));
                continue;
            }

            answer.append(type.charAt(1));
        }

        return answer.toString();
    }

}
