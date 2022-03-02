package leetCode;

import java.util.Stack;

// Daily Temperatures
public class Solution739 {

    public int[] dailyTemperatures1(int[] temperatures) {
        int[] answer = new int[temperatures.length];

        for (int i = 0; i < temperatures.length - 1; ++i) {
            int now = temperatures[i];
            for (int j = i + 1; j < temperatures.length; ++j) {
                if (temperatures[j] > now) {
                    answer[i] = j - i;
                    break;
                }
            }
        }

        return answer;
    }

    public int[] dailyTemperatures2(int[] temperatures) {
        int[] answer = new int[temperatures.length];

        Stack<Integer> indexStack = new Stack<>();
        Stack<Integer> temperatureStack = new Stack<>();

        indexStack.push(0);
        temperatureStack.push(temperatures[0]);

        for (int i = 1; i < temperatures.length; ++i) {
            while (!indexStack.isEmpty() && temperatureStack.peek() < temperatures[i]) {
                answer[indexStack.peek()] = i - indexStack.pop();
                temperatureStack.pop();
            }

            indexStack.push(i);
            temperatureStack.push(temperatures[i]);
        }

        return answer;
    }
}
