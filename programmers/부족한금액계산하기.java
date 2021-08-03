package programmers;

// https://programmers.co.kr/learn/courses/30/lessons/82612
public class 부족한금액계산하기 {

    static public long solution(int price, int money, int count) {
        long answer = money;

        for (int i = 1; i <= count; ++i) {
            answer -= ((long) price * i);
        }

        return answer > 0 ? 0 : -answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(3, 20, 4));
    }
}
