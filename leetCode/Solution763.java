package leetCode;

import java.util.ArrayList;
import java.util.List;

// Partition Labels
public class Solution763 {

    public static List<Integer> partitionLabels(String s) {
        List<Integer> answer = new ArrayList<>();

        int count = 0;
        int lastIndex = 0;

        for (int i = 0; i < s.length(); ++i) {
            if (lastIndex < i) {
                answer.add(count);
                count = 0;
            }

            lastIndex = Math.max(lastIndex, s.lastIndexOf(s.charAt(i)));
            ++count;
        }

        answer.add(count);

        return answer;
    }

    public static List<Integer> partitionLabelsV2(String s) {
        List<Integer> answer = new ArrayList<>();

        int[] lastIndexes = new int[26];

        for (int i = 0; i < s.length(); ++i) {
            lastIndexes[s.charAt(i) - 'a'] = i;
        }

        int count = 0;
        int maxLastIndex = 0;

        for (int i = 0; i < s.length(); ++i) {
            maxLastIndex = Math.max(maxLastIndex, lastIndexes[s.charAt(i) - 'a']);
            ++count;

            if (maxLastIndex == i) {
                answer.add(count);
                count = 0;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        String s = "ababcbacadefegdehijhklij";

        partitionLabelsV2(s).forEach(System.out::println);
    }
}
