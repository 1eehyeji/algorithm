package programmers.level1;

public class 문자열나누기 {
    public int solution(String s) {
        int answer = 0;

        char x = s.charAt(0);
        int xCount = 1;
        int otherCount = 0;

        for (int i = 1; i < s.length(); ++i) {
            if (xCount == 0) {
                x = s.charAt(i);
                ++xCount;
                continue;
            }

            if (x == s.charAt(i)) ++xCount;
            else ++otherCount;

            if (xCount == otherCount) {
                ++answer;
                xCount = 0;
                otherCount = 0;
            }
        }

        if (xCount > 0 || otherCount > 0) ++answer;

        return answer;
    }
}
