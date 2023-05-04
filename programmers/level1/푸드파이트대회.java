package programmers.level1;

public class 푸드파이트대회 {

    public String solution(int[] food) {
        StringBuilder answer = new StringBuilder();
        int mid = 0;

        for (int i = 1; i < food.length; ++i) {
            int count = food[i] / 2;

            for (int j = 0; j < count * 2; ++j) {
                answer.insert(mid + j, i);
            }

            mid += count;
        }

        return answer.insert(mid, 0).toString();
    }
}
