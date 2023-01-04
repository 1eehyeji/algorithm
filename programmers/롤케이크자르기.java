package programmers;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class 롤케이크자르기 {

    public static int solution(int[] topping) {
        int answer = 0;

        Map<Integer, Integer> toppingCountMap = new HashMap<>();

        for (int i : topping) {
            toppingCountMap.put(i, toppingCountMap.getOrDefault(i, 0) + 1);
        }

        Set<Integer> toppingSet = new HashSet<>();

        for (int i : topping) {
            toppingSet.add(i);
            toppingCountMap.put(i, toppingCountMap.get(i) - 1);

            if (toppingCountMap.get(i) == 0) {
                toppingCountMap.remove(i);
            }

            if (toppingSet.size() == toppingCountMap.size()) {
                ++answer;
            }
        }

        return answer;
    }


    public static void main(String[] args) {
        System.out.println(solution(new int[] {1, 2, 1, 3, 1, 4, 1, 2}));
    }
}
