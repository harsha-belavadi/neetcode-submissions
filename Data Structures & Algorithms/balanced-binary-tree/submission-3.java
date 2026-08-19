/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public boolean isBalanced(TreeNode root) {
        return dfs(root) != -1;
    }

    private int dfs(TreeNode root) {
        if (root == null) { return 0; }

        // 1. Check if the left subtree is balanced
        int left = dfs(root.left);
        if (left == -1) { return -1; }

        // 2. Check if the right subtree is balanced
        int right = dfs(root.right);
        if (right == -1) { return -1; }

        // 3. Check if the current node itself is balanced
        if (Math.abs(left - right) > 1) {
            return -1; 
        }

        // 4. If everything is fine, return the actual height
        return 1 + Math.max(left, right);
    }
}
