package programmers.kakao2022;

import java.util.*;
import java.util.stream.Collectors;

public class 신고결과받기 {

    public static int[] solution(String[] id_list, String[] reports, int k) {
        int[] answer = new int[id_list.length];

        Map<String, Integer> userIndexMap = new HashMap<>();

        for (int i = 0; i < id_list.length; ++i) {
            userIndexMap.put(id_list[i], i);
        }

        Map<String, Set<String>> reportedUserMap = new HashMap<>();

        // Set을 사용하지 않고 주어진 신고내역 자체에서 중복을 제거하는 방법
        // stream의 distinct를 사용
        //List<String> distinctReport = Arrays.stream(reports).distinct().collect(Collectors.toList());

        for (String report : reports) {
            String[] reportToken = report.split(" ");

            reportedUserMap.put(reportToken[1],
                    reportedUserMap.getOrDefault(reportToken[1], new HashSet<>()));
            reportedUserMap.get(reportToken[1]).add(reportToken[0]);
        }

        for (Map.Entry<String, Set<String>> entry : reportedUserMap.entrySet()) {
            if (entry.getValue().size() < k) continue;

            for (String user : entry.getValue()) {
                answer[userIndexMap.get(user)] += 1;
            }
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
