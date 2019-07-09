package codingTest.W0316;

public class Test5 {

    public static int solution(int number) {
        int answer = 0;

        for(int i = 1; i <= number; ++i) {
            int num = i;
            while (num > 0) {
                int n = num % 10;
                if(n == 3 || n == 6 || n == 9) {
                    ++answer;
                }
                num /= 10;
            }

        }

        return answer;
    }

    public static void main(String[] args) {
        int number = 33;

        System.out.println(solution(number));
    }
}
