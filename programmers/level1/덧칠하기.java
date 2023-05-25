package programmers.level1;

public class 덧칠하기 {

    public int solution(int n, int m, int[] section) {
        int answer = 0;

        int paintedSectionNum = -1;

        for (int j : section) {
            if (j > paintedSectionNum) {
                ++answer;
                paintedSectionNum = (j + m) - 1;
            }
        }

        return answer;
    }
}
