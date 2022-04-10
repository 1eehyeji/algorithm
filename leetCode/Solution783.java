package leetCode;

import java.util.ArrayList;
import java.util.List;

public class Solution783 {

    List<Integer> numbers;

    public int minDiffInBST(TreeNode root) {
        numbers = new ArrayList<>();
        inorder(root);

        int min = Integer.MAX_VALUE;

        for (int i = 0; i < numbers.size() - 1; ++i) {
            min = Math.min(min, numbers.get(i + 1) - numbers.get(i));
        }

        return min;
    }

    private void inorder(TreeNode node) {
        if (node == null) {
            return;
        }

        inorder(node.left);
        numbers.add(node.val);
        inorder(node.right);
    }
}

class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}