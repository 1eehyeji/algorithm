package programmers.level1;

public class P2016년 {

    public String solution(int a, int b) {
        String answer = "";

        int[] month = { 0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        String[] week = { "THU", "FRI", "SAT", "SUN", "MON", "TUE", "WED" };

        int day = 0;
        for (int i = 1; i < a; ++i) {
            day += month[i];
        }

        answer = week[(day + b) % 7];

        return answer;
    }
}
