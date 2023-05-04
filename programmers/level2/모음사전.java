package programmers.level2;

import java.util.Set;
import java.util.TreeSet;

public class 모음사전 {

    static String[] vowel = {"A", "E", "I", "O", "U"};

    public static int solution(String word) {
        int answer = 0;

        Set<String> set = new TreeSet<>();

        for (int i = 1; i <= 5; ++i) {
            rePermutation(vowel.length, i, new StringBuilder(), set);
        }

        for (String s : set) {
            ++answer;
            if (s.equals(word)) break;
        }

        return answer;
    }

    private static void rePermutation(int n, int r, StringBuilder sb, Set<String> set) {
        if (sb.length() == r) {
            set.add(sb.toString());
            return;
        }

        for (int i = 0; i < n; ++i) {
            sb.append(vowel[i]);
            rePermutation(n, r, sb, set);
            sb.delete(sb.length() - 1, sb.length());
        }
    }

    public static void main(String[] args) {
        String word = "I";

        System.out.println(solution(word));
    }
}
