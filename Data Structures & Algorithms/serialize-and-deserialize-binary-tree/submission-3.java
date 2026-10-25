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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "";
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            int queue_len = queue.size();
            for (int i=0; i<queue_len; i++) {
                TreeNode node = queue.poll();
                String value = "null";
                if (node != null) {
                    value = String.valueOf(node.val);
                    queue.offer(node.left);
                    queue.offer(node.right);
                }
                sb.append(value);
                if (i < queue_len - 1) {
                    sb.append(",");
                }
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.isEmpty()) return null;
        List<List<TreeNode>> levels = new ArrayList<>();
        for (String values : data.split("\\n")) {
            List<TreeNode> level = new ArrayList<>();
            for (String value : values.split(",")) {
                TreeNode node = null;
                if (!value.equals("null")) {
                    node = new TreeNode(Integer.parseInt(value));
                }
                level.add(node);
            }
            levels.add(level);
        }

        TreeNode root = levels.get(0).get(0);
        int n = levels.size();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        for (int i=1; i<n; i++) {
            List<TreeNode> level = levels.get(i);
            int queue_len = queue.size();
            int level_idx = 0;
            for (int j=0; j<queue_len; j++) {
                TreeNode node = queue.poll();
                if (node != null) {
                    node.left = level.get(level_idx++);
                    node.right = level.get(level_idx++);
                    queue.offer(node.left);
                    queue.offer(node.right);
                }
            }
        }
        return root;
    }
}
