package programmers.kakao2021;

import java.util.*;

public class 순위검색 {

    public int[] solution(String[] infos, String[] query) {
        int[] answer = new int[query.length];

        Map<String, List<Integer>> infoMap = new HashMap<>();

        for (String info : infos) {
            String[] infoTokens = info.split(" ");

            setInfoMap(infoMap, infoTokens, 0, new String[infoTokens.length - 1]);
        }

        infoMap.keySet().forEach(key -> Collections.sort(infoMap.get(key)));

        for (int i = 0; i < query.length; ++i) {
            String[] queryTokens = query[i].split(" and | ");

            String requiredCondition = String.join(" ", Arrays.copyOf(queryTokens, 4));

            int requiredScore = Integer.parseInt(queryTokens[queryTokens.length - 1]);

            if (!infoMap.containsKey(requiredCondition)) continue;

            List<Integer> scoreList = infoMap.get(requiredCondition);
            answer[i] = scoreList.size() - lowerBound(scoreList, requiredScore);
        }

        return answer;
    }

    private int lowerBound(List<Integer> list, int requiredScore) {
        int left = 0;
        int right = list.size() - 1;

        int mid;

        while (right >= left) {
            mid = (left + right) / 2;

            if (list.get(mid) < requiredScore) {
                left = mid + 1;
                continue;
            }

            right = mid - 1;
        }

        return left;
    }

    private void setInfoMap(Map<String, List<Integer>> infoMap, String[] infoTokens, int index, String[] tokens) {
        if (index == infoTokens.length - 1) {
            String info = String.join(" ", tokens);
            infoMap.put(info, infoMap.getOrDefault(info, new ArrayList<>()));
            infoMap.get(info).add(Integer.parseInt(infoTokens[index]));
            return;
        }

        tokens[index] = infoTokens[index];
        setInfoMap(infoMap, infoTokens, index + 1, tokens);
        tokens[index] = "-";
        setInfoMap(infoMap, infoTokens, index + 1, tokens);
    }

    public static void main(String[] args) {
        순위검색 rankingSearcher = new 순위검색();

        System.out.println(Arrays.toString(rankingSearcher.solution(
                new String[]{
                        "java backend junior pizza 150",
                        "python frontend senior chicken 210",
                        "python frontend senior chicken 150",
                        "cpp backend senior pizza 260",
                        "java backend junior chicken 80",
                        "python backend senior chicken 50"
                },
                new String[]{
                        "java and backend and junior and pizza 100",
                        "python and frontend and senior and chicken 200",
                        "cpp and - and senior and pizza 250",
                        "- and backend and senior and - 150",
                        "- and - and - and chicken 100",
                        "- and - and - and - 150"
                }
        )));
    }
}
