package programmers.level1;

public class 없는숫자더하기 {

    final static int ZEROTONINE = 45;

    public static int solution(int[] numbers) {
        int answer = 0;

        for (int number : numbers) {
            answer += number;
        }

        return ZEROTONINE - answer;
    }

    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 6, 7, 8, 0};

        System.out.println(solution(numbers));
    }
}
