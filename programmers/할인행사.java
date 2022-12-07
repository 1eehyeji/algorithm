package programmers;

import java.util.*;

public class 할인행사 {

    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;

        Map<String, Integer> wantMap = new HashMap();

        for (int i = 0; i < want.length; ++i) {
            wantMap.put(want[i], number[i]);
        }

        Map<String, Integer> discountMap = new HashMap();
        int memberPeriod = 10;

        for (int i = 0; i < discount.length; ++i) {
            if (i >= memberPeriod) {
                int index = (i - memberPeriod);
                discountMap.put(discount[index], discountMap.get(discount[index]) - 1);
            }

            discountMap.put(discount[i], discountMap.getOrDefault(discount[i], 0) + 1);

            if (isSatisfied(wantMap, discountMap)) {
                ++answer;
            }
        }

        return answer;
    }

    public boolean isSatisfied(Map<String, Integer> wantMap, Map<String, Integer> discountMap) {
        for (Map.Entry<String, Integer> want : wantMap.entrySet()) {
            if (discountMap.get(want.getKey()) == null
                    || want.getValue() > discountMap.get(want.getKey())) {
                return false;
            }
        }

        return true;
    }

}
