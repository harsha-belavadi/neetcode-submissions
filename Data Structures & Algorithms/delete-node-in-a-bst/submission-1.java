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
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return root;
        } else if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else if (key > root.val) {
            root.right = deleteNode(root.right, key);
        } else {
            if (root.left == null && root.right == null) {
                root = null;
                return root;
            } else if (root.left == null) {
                TreeNode temp = root;
                root = root.right;
                temp = null;
                return root;
            } else if (root.right == null) {
                TreeNode temp = root;
                root = root.left;
                temp = null;
                return root;
            } else {
                TreeNode temp = getMin(root.right);
                root.val = temp.val;
                root.right = deleteNode(root.right, temp.val);
            }
        }
        return root;
    }

    private TreeNode getMin(TreeNode root) {
        if (root.left == null) {
            return root;
        }
        return getMin(root.left);
    }
}