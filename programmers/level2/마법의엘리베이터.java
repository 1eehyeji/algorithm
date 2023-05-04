package programmers.level2;

public class 마법의엘리베이터 {
    public int solution(int storey) {
        int answer = 0;

        while(storey > 0) {
            int n = storey % 10;
            storey /= 10;

            if (n < 5 || (n == 5 && (storey % 10) < 5)) {
                answer += n;
                continue;
            }

            answer += (10 - n);
            storey += 1;

        }

        return answer;
    }
}
