package programmers.level2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class 혼자놀기의달인 {

    public static int solution(int[] cards) {
        boolean[] isOpened = new boolean[cards.length];
        List<Integer> cardCountsOfGroup = new ArrayList<>();

        int boxNumber = 0;
        int openCount = 0;
        while (boxNumber != -1) {
            if (isOpened[boxNumber]) {
                cardCountsOfGroup.add(openCount);

                boxNumber = getNotOpenedBoxNumber(isOpened);
                openCount = 0;

                continue;
            }

            isOpened[boxNumber] = true;
            boxNumber = cards[boxNumber] - 1;
            ++openCount;
        }

        if (cardCountsOfGroup.size() <= 1) {
            return 0;
        }

        cardCountsOfGroup.sort(Comparator.reverseOrder());

        return cardCountsOfGroup.get(0) * cardCountsOfGroup.get(1);
    }

    private static int getNotOpenedBoxNumber(boolean[] isOpened) {
        for (int i = 0; i < isOpened.length; ++i) {
            if (!isOpened[i]) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[] {8, 6, 3, 7, 2, 5, 1, 4}));
    }
}
