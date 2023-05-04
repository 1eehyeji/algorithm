package programmers.level2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class 입실퇴실 {

    public static int[] solution(int[] enter, int[] leave) {
        int[] answer = new int[enter.length];

        List<Integer> list = new LinkedList<>();

        int i = 0;
        int j = 0;
        while (i != enter.length || j != leave.length) {
            if (list.contains(leave[j])) {
                for (Integer integer : list) {
                    if (integer != leave[j]) {
                        ++answer[integer - 1];
                        ++answer[leave[j] - 1];
                    }
                }
                list.remove((Integer) leave[j]);
                ++j;
            } else {
                list.add(enter[i]);
                ++i;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] enter = {1, 4, 2, 3};
        int[] leave = {2, 1, 3, 4};

        System.out.println(Arrays.toString(solution(enter, leave)));
    }
}
