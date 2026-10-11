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
        if (root == null) return root;

        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else if (key > root.val) {
            root.right = deleteNode(root.right, key);
        } else {
            if (root.left == null && root.right == null) {
                root = null;
                return null;
            } else if (root.left == null) {
                TreeNode node = root;
                root = root.right;
                node = null;
                return root;
            } else if (root.right == null) {
                TreeNode node = root;
                root = root.left;
                node = null;
                return root;
            } else {
                TreeNode node = getMin(root.right);
                root.val = node.val;
                root.right = deleteNode(root.right, node.val);
                return root;
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