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
    public int goodNodes(TreeNode root) {
        return helper(root, Integer.MIN_VALUE, 0);
    }

    private int helper(TreeNode root, int maxInPath, int count) {
        if (root == null) return count;

        if (root.val >= maxInPath) {
            count++;
            maxInPath = root.val; 
        }
        
        count = helper(root.left, maxInPath, count);
        count = helper(root.right, maxInPath, count);
        
        return count;
    }
}
