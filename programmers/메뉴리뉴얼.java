package programmers;

import java.util.*;
import java.util.List;

public class 메뉴리뉴얼 {

    Map<String, Integer> courses;

    public String[] solution(String[] orders, int[] course) {
        List<String> answer = new ArrayList<>();
        courses = new HashMap<>();

        for (int orderedCount : course) {
            for (String order : orders) {
                if (order.length() < orderedCount)
                    continue;
                makeCourse(orderedCount, 0, "", sortOrder(order));
            }
            getMostOrderedMenus(answer);
            courses = new HashMap<>();
        }

        answer.sort(String::compareTo);
        return answer.toArray(new String[0]);
    }

    // 주문한 메뉴 조합 사전순으로 정렬
    private String sortOrder(String order) {
        char[] chars = order.toCharArray();
        Arrays.sort(chars);
        return String.valueOf(chars);
    }

    // 손님들이 가장 많이 주문한 메뉴조합 목록을 구함
    private void getMostOrderedMenus(List<String> list) {
        Optional<Integer> mostOrderedCount = courses.values().stream().max(Integer::compareTo);

        if (!mostOrderedCount.isPresent() || mostOrderedCount.get() < 2)
            return;

        for (String course : courses.keySet()) {
            if (courses.get(course).equals(mostOrderedCount.get()))
                list.add(course);
        }
    }

    // 메뉴 조합
    public void makeCourse(int length, int k, String course, String order) {
        if (length == 0) {
            courses.put(course, courses.getOrDefault(course, 0) + 1);
            return;
        }

        for (int i = k; i < order.length(); ++i) {
            makeCourse(length - 1, ++k, course + order.charAt(i), order);
        }
    }

    public static void main(String[] args) {
        String[] order = {"XYZ", "XWY", "WXA"};
        int[] course = {2, 3, 4};

        메뉴리뉴얼 m = new 메뉴리뉴얼();
        String[] answer = m.solution(order, course);

        for (String s : answer)
            System.out.println(s);
    }
}




