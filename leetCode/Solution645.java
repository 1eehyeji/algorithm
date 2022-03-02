package leetCode;

// Set Mismatch
public class Solution645 {

    public int[] findErrorNums(int[] nums) {
        int[] answer = new int[2];

        int[] count = new int[nums.length];

        for (int i = 0; i < nums.length; ++i) {
            ++count[nums[i] - 1];
        }

        for (int i = 0; i < count.length; ++i) {
            if (count[i] == 0) answer[1] = i + 1;
            if (count[i] == 2) answer[0] = i + 1;
        }

        return answer;
    }
}
