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
    int[] result = new int[2];
    public int kthSmallest(TreeNode root, int k) {
        result[0] = k;
        result[1] = root.val;
        inorder(root);
        return result[1];
    }

    private boolean inorder(TreeNode root) {
        if (root == null) return false;     

        // Inorder Traversal
 
        if (inorder(root.left)) return true;
        result[0]--;
        if (result[0] == 0) {
            result[1] = root.val;
            return true;
        };
        return inorder(root.right);
    }
}
