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
    boolean deleted = false;
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        if (root == null) return null;
        TreeNode node = helper(root, target);
        if (deleted) {
            deleted = false;
            return removeLeafNodes(node, target);
        }
        return root;
    }

    private TreeNode helper(TreeNode root, int target) {
        if (root == null) return null;
        if (root.left == null && root.right == null && root.val == target) {
            root = null;
            deleted = true;
            return null;
        }

        root.left = helper(root.left, target);
        root.right = helper(root.right, target);

        return root;
    }
}