package programmers;

import java.util.Arrays;

public class 로또의최고순위와최저순위 {

    static int[] solution(int[] lottos, int[] win_nums) {
        int[] rank = {6, 6, 5, 4, 3, 2, 1};
        int[] winNums = new int[46];
        for (int i : win_nums) {
            ++winNums[i];
        }

        int countZero = 0;
        int countMatchedNumber = 0;

        for (int i : lottos) {
            if (i == 0) ++countZero;
            if (winNums[i] > 0) ++countMatchedNumber;
        }

        return new int[]{rank[countMatchedNumber], rank[countMatchedNumber + countZero]};
    }

    public static void main(String[] args) {
        int[] lottos = {44, 1, 0, 0, 31, 25};
        int[] win_nums = {31, 10, 45, 1, 6, 19};

        System.out.println(Arrays.toString(solution(lottos, win_nums)));
    }
}
