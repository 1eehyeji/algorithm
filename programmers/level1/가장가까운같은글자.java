package programmers.level1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class 가장가까운같은글자 {

    public static int[] solution(String s) {
        int[] answer = new int[s.length()];

        Map<String, Integer> alphabetIndexMap = new HashMap<>();

        for (int i = 0; i < s.length(); ++i) {
            String alphabet = Character.toString(s.charAt(i));

            answer[i] = !alphabetIndexMap.containsKey(alphabet) ? -1 : i - alphabetIndexMap.get(alphabet);

            alphabetIndexMap.put(alphabet, i);
        }

        return answer;
    }
}
