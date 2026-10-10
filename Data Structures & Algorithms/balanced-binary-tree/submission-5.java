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
    int not_balanced = Integer.MAX_VALUE;
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        int result = dfs(root);
        return result != not_balanced;
    }

    private int dfs(TreeNode root) {
        if (root == null) return 0;

        int left = dfs(root.left);
        if (left == not_balanced) {
            return not_balanced;
        }

        int right = dfs(root.right);
        if (right == not_balanced) {
            return not_balanced;
        }

        if (Math.abs(left - right) > 1) {
            return not_balanced;
        }

        return 1 + Math.max(left, right);
    } 
}
