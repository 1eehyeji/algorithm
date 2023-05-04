package programmers.level1;

public class 기사단원의무기 {

    public int solution(int number, int limit, int power) {
        int answer = 1;

        for (int i = 2; i <= number; ++i) {
            int count = 0;

            for (int j = 1;  j * j <= i; ++j) {
                if (i % j == 0) {
                    count += (j * j == i) ? 1 : 2;
                }

                if (count > limit) {
                    count = power;
                    break;
                }
            }

            answer += count;
        }

        return answer;
    }
}
