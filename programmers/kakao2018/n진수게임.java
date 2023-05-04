package programmers.kakao2018;

public class n진수게임 {
    public static String solution(int n, int t, int m, int p) {
        StringBuilder sb = new StringBuilder();
        StringBuilder answer = new StringBuilder();
        char[] numbers = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

        for (int i = 0; sb.length() < t * m; ++i) {
            StringBuilder temp = new StringBuilder();
            int num = i;
            while (num / n != 0) {
                temp.insert(0, numbers[num % n]);
                num /= n;
            }
            temp.insert(0, numbers[num % n]);
            sb.append(temp.toString());
        }

        char[] chars = sb.toString().toCharArray();
        int tube = p - 1;
        for (int i = 0; i < t; ++i) {
            answer.append(chars[tube]);
            tube += m;
        }

        return answer.toString();
    }

    public static void main(String[] args) {
        System.out.println(solution(16, 16, 2, 2));
    }
}
