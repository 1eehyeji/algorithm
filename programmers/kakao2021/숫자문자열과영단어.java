package programmers.kakao2021;

public class 숫자문자열과영단어 {

    static final String[] numbers = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

    public static int solution(String s) {
        String answer = s;

        for (int i = 0; i < numbers.length; ++i) {
            answer = answer.replaceAll(numbers[i], String.valueOf(i));
        }

        return Integer.parseInt(answer);
    }

    public static void main(String[] args) {
        System.out.println(solution("one4seveneight"));
        System.out.println(solution("23four5six7"));
        System.out.println(solution("2three45sixseven"));
        System.out.println(solution("123"));
    }
}
