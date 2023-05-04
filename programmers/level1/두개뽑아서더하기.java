package programmers.level1;

import java.util.Set;
import java.util.TreeSet;

public class 두개뽑아서더하기 {

    public int[] solution(int[] numbers) {
        Set<Integer> numberSet = new TreeSet<>();

        for (int i = 0; i < numbers.length; ++i) {
            for (int j = 0; j < numbers.length; ++j) {
                if (i != j) {
                    numberSet.add(numbers[i] + numbers[j]);
                }
            }
        }

        return numberSet.stream().mapToInt(i -> i).toArray();
    }
}
