package programmers;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class 소수찾기_level2 {

    public static int solution(String numbers) {
        int answer = 0;

        boolean[] isPrimeNumber = new boolean[10000000];
        Arrays.fill(isPrimeNumber, true);
        isPrimeNumber[0] = isPrimeNumber[1] = false;

        for (int i = 2; i < isPrimeNumber.length; ++i) {
            if (!isPrimeNumber[i]) continue;
            for (int j = i * 2; j < isPrimeNumber.length; j += i) {
                isPrimeNumber[j] = false;
            }
        }

        Set<Integer> numberSet = new HashSet<>();

        for (int i = 1; i <= numbers.length(); ++i) {
            permutation(numberSet, numbers.toCharArray(), new boolean[numbers.length()], 0, i, "");
        }

        for (int number : numberSet.stream().sorted().collect(Collectors.toList())) {
            System.out.println(number + " " + isPrimeNumber[number]);
            if (isPrimeNumber[number]) ++answer;
        }

        return answer;
    }

    private static void permutation(Set<Integer> numberSet, char[] numbers, boolean[] visited, int depth, int n, String number) {
        if (depth == n) {
            numberSet.add(Integer.parseInt(number));
            return;
        }

        for (int i = 0; i < numbers.length; ++i) {
            if(visited[i]) continue;

            visited[i] = true;
            permutation(numberSet, numbers, visited, depth + 1, n, number + numbers[i]);
            visited[i] = false;
        }
    }

    public static void main(String[] args) {
        System.out.println(solution("1231"));
    }
}
