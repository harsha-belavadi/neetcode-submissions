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
    List<Integer> nodes = new ArrayList<>();
    public int kthSmallest(TreeNode root, int k) {
        dfs(root, k);
        return nodes.get(k - 1);
    }

    private void dfs(TreeNode root, int k) {
        if (root == null) { return; }
        dfs(root.left, k);
        nodes.add(root.val);
        dfs(root.right, k);
    }
}
