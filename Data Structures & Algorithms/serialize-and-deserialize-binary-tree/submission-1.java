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
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) sb.append("null,");
            else {
                sb.append(node.val).append(",");
                queue.offer(node.left);
                queue.offer(node.right);
            }
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.isEmpty()) return null;

        String[] values = data.split(",");
        if (values[0].equals("null")) return null;

        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        queue.offer(root);

        int index = 1;
        while (index < values.length) {
            TreeNode parent = queue.poll();
            if (parent == null) continue;

            String value = values[index];
            if (isNotBlank(value)) {
                parent.left = new TreeNode(Integer.parseInt(value));
                queue.offer(parent.left);
            }

            index++;
            if (index > values.length) {
                break;
            }

            value = values[index];
            if (isNotBlank(value)) {
                parent.right = new TreeNode(Integer.parseInt(value));
                queue.offer(parent.right);
            }

            index++;
        }

        return root;
    }

    private boolean isNotBlank(String value) {
        return !value.equals("null") && !value.isEmpty();
    }
}
