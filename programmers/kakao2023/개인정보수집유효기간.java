package programmers.kakao2023;

import java.util.*;

public class 개인정보수집유효기간 {
    public static int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> expiredList = new ArrayList<>();

        // 현재 날짜 정보 배열
        // 0: 년 1: 월 2: 일
        int[] todayArr = Arrays.stream(today.split("\\.")).mapToInt(Integer::parseInt).toArray();

        // 약관, 유효기간 정보를 저장한 Map
        Map<String, Integer> termMap = new HashMap<>();
        for (String term : terms) {
            // 0: 약관 종류 1: 유효기간
            String[] termArr = term.split(" ");
            termMap.put(termArr[0], Integer.valueOf(termArr[1]));
        }

        for (int i = 0; i < privacies.length; ++i) {
            String privacy = privacies[i];

            StringTokenizer st = new StringTokenizer(privacy);
            String date = st.nextToken();
            String term = st.nextToken();

            st = new StringTokenizer(date, ".");
            int year = Integer.parseInt(st.nextToken());
            int month = Integer.parseInt(st.nextToken());
            int day = Integer.parseInt(st.nextToken());

            month += termMap.get(term);

            if (month > 12) {
                year += month / 12;
                month -= 12 * (month / 12);

                if (month == 0) {
                    year -= 1;
                    month += 12;
                }
            }

            if (todayArr[0] > year) {
                expiredList.add(i + 1);
                continue;
            }

            if (todayArr[0] == year) {
                if (todayArr[1] > month) {
                    expiredList.add(i + 1);
                    continue;
                }

                if (todayArr[1] == month && todayArr[2] >= day) {
                    expiredList.add(i + 1);
                }
            }
        }

        return expiredList.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {
        String today = "2020.12.01";
        String[] terms = {"A 12"};
        String[] privacies = {"2019.12.01 A"};

        System.out.println(Arrays.toString(solution(today, terms, privacies)));
    }
}
