package programmers.kakao2022;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class 신고결과받기 {

    public static int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];

        Map<String, Integer> reportedCountMap = new HashMap<>();

        for (int i = 0; i < report.length; ++i) {
            String[] arr = report[i].split(" ");
            reportedCountMap.put(arr[1], reportedCountMap.getOrDefault(arr[1], 0) + 1);
        }

        Map<String, Integer> mailCountMap = new HashMap<>();

        for (int i = 0; i < report.length; ++i) {
            String[] arr = report[i].split(" ");
            if (reportedCountMap.get(arr[1]) >= k) {
                mailCountMap.put(arr[0], mailCountMap.getOrDefault(arr[0], 0) + 1);
            }
        }

        for (int i = 0; i < id_list.length; ++i) {
            answer[i] = mailCountMap.getOrDefault(id_list[i], 0);
        }

        return answer;
    }

    public static void main(String[] args) {
        String[] id_list = {"muzi", "frodo", "apeach", "neo"};
        String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
        int k = 2;

        System.out.println(Arrays.toString(solution(id_list, report, k)));
    }
}
