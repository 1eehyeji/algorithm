package leetCode;

// Sum of All Subset XOR Totals
public class Solution1863 {

    int answer = 0;

    public int subsetXORSum(int[] nums) {
        for (int i = 0; i < nums.length; ++i) {
            subsetXORSum(nums, i, nums[i]);
        }

        return answer;
    }

    private void subsetXORSum(int[] nums, int i, int sum) {
        answer += sum;

        for (int j = i + 1; j < nums.length; ++j) {
            subsetXORSum(nums, j, sum ^ nums[j]);
        }
    }
}
