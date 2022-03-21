package leetCode;

// Sum of All Subset XOR Totals
public class Solution1863 {

    int answer = 0;

    public int subsetXORSum(int[] nums) {
        subsetXORSum(nums, 0, 0);

        return answer;
    }

    private void subsetXORSum(int[] nums, int i, int sum) {
        answer += sum;

        for (int j = i; j < nums.length; ++j) {
            subsetXORSum(nums, j + 1, sum ^ nums[j]);
        }
    }
}
