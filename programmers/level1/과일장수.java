package programmers.level1;

import java.util.Arrays;

public class 과일장수 {

    public int solution(int k, int m, int[] score) {
        int answer = 0;

        Arrays.sort(score);

        int boxCount = score.length / m;
        int index = score.length - m;

        while(boxCount --> 0) {
            answer += score[index] * m;
            index -= m;
        }

        return answer;
    }
}
