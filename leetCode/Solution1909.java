package leetCode;

import java.util.Stack;

// Remove One Element to Make the Array Strictly Increasing
public class Solution1909 {

    public static boolean canBeIncreasing(int[] nums) {
        for (int i = 0; i < nums.length; ++i) {
            int pre = 0;
            boolean flag = true;
            for (int j = 0; j < nums.length; ++j) {
                if (i == j) continue;
                if (nums[j] <= pre) {
                    flag = false;
                    continue;
                }
                pre = nums[j];
            }

            if(flag) return true;
        }

        return false;
    }

    public static boolean canBeIncreasingV2(int[] nums) {
        int count = 0;

        for (int i = 1; i < nums.length; ++i) {
            if (nums[i - 1] >= nums[i]) {
                ++count;
            }

            if (i > 1 && nums[i] <= nums[i - 2]) {
                nums[i] = nums[i - 1];
            }

            if (count > 1) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int[] nums1 = {2, 3, 1, 2};
        int[] nums2 = {1, 2, 10, 5, 7};
        int[] nums3 = {1, 1, 1};
        int[] nums4 = {105,924,32,968};

        System.out.println(canBeIncreasingV2(nums2));
    }
}
