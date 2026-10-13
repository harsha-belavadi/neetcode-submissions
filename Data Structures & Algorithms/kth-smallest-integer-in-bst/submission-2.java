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
    int k;
    public int kthSmallest(TreeNode root, int k) {
        this.k = k;
        return helper(root);
    }

    private int helper(TreeNode root) {
        if (root == null) return -1;     

        // Inorder Traversal
 
        int left = helper(root.left);
        if (left > -1) return left;
        
        k--;
        if (k == 0) return root.val;
        
        int right = helper(root.right);
        if (right > -1) return right;
        
        return -1;
    }
}
