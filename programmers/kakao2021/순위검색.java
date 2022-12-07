package programmers.kakao2021;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class 순위검색 {

    String[][] conditions = {{"cpp", "java", "python"},
            {"backend", "frontend"},
            {"junior", "senior"},
            {"chicken", "pizza"}};

    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];

        Map<String, List<Integer>> infoMap = new HashMap<>();

        Pattern conditionPattern = Pattern.compile("([a-z\\s]+)\\s([0-9]+)");

        for (String infoOfApplicant : info) {
            Matcher matcher = conditionPattern.matcher(infoOfApplicant);

            if (!matcher.find()) {
                continue;
            }

            String condition = matcher.group(1);
            String point = matcher.group(2);

            infoMap.put(condition, infoMap.getOrDefault(condition, new ArrayList<>()));
            infoMap.get(condition).add(Integer.parseInt(point));
        }

        Pattern queryPattern = Pattern.compile("([a-z\\s\\-]+)\\s([0-9]+)");

        for (int i = 0; i < query.length; ++i) {
            Matcher matcher = queryPattern.matcher(query[i]);

            if (!matcher.find()) {
                continue;
            }

            String condition = matcher.group(1);
            int point = Integer.parseInt(matcher.group(2));

            String[] token = condition.split(" and ");
            List<String> conditionList = new ArrayList<>();
            getConditionString(0, token.length, token, "", conditionList);

            for (String s : conditionList) {
                if (infoMap.get(s) == null) {
                    continue;
                }

                for (int p : infoMap.get(s)) {
                    if (point <= p) {
                        ++answer[i];
                    }
                }
            }
        }

        return answer;
    }

    private void getConditionString(int start, int end, String[] token, String condition, List<String> conditionList) {
        if (start == end) {
            conditionList.add(condition.trim());
            return;
        }

        if (token[start].equals("-")) {
            for (String s : conditions[start]) {
                getConditionString(start + 1, end, token, condition + s + " ", conditionList);
            }
            return;
        }

        getConditionString(start + 1, end, token, condition + token[start] + " ", conditionList);
    }

    public static void main(String[] args) {
        순위검색 rankingSearcher = new 순위검색();

        System.out.println(rankingSearcher.solution(
                new String[]{"java backend junior pizza 150", "python frontend senior chicken 210", "python frontend senior chicken 150", "cpp backend senior pizza 260", "java backend junior chicken 80", "python backend senior chicken 50"},
                new String[]{"java and backend and junior and pizza 100", "python and frontend and senior and chicken 200", "cpp and - and senior and pizza 250", "- and backend and senior and - 150", "- and - and - and chicken 100", "- and - and - and - 150"}
        ));
    }
}
