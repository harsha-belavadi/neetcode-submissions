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
        StringBuilder serialized = new StringBuilder();
        while(!queue.isEmpty()) {
            int queue_len = queue.size();
            for (int i=0; i<queue_len; i++) {
                TreeNode node = queue.poll();
                if (node == null) serialized.append("null");
                else serialized.append(String.valueOf(node.val));
                if (i < queue_len - 1) serialized.append(",");
                if (node != null) {
                    queue.offer(node.left);
                    queue.offer(node.right);
                }
            }
            serialized.append("#");
        }
        return serialized.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.isEmpty()) return null;

        List<List<TreeNode>> levels = new ArrayList<>();
        for (String splitted : data.split("#")) {
            String[] nodes = splitted.split(",");
            List<TreeNode> level = new ArrayList<>();
            for (String node : nodes) {
                if (node.equals("null")) level.add(null);
                else level.add(new TreeNode(Integer.parseInt(node)));
            }
            levels.add(level);
        }

        if (levels.get(0).get(0) == null) {
            return null;
        }

        TreeNode root = levels.get(0).get(0);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int levelIdx = 1;
        while (!queue.isEmpty() && levelIdx < levels.size()) {
            List<TreeNode> nextLevelNodes = levels.get(levelIdx);
            int currentLevelSize = queue.size();
            int childIdx = 0;
            for (int i=0; i<currentLevelSize; i++) {
                TreeNode parent = queue.poll();
                if (parent == null) continue;
                
                if (childIdx < nextLevelNodes.size()) {
                    TreeNode leftChild = nextLevelNodes.get(childIdx++);
                    parent.left = leftChild;
                    if (leftChild != null) queue.offer(leftChild);
                }

                if (childIdx < nextLevelNodes.size()) {
                    TreeNode rightChild = nextLevelNodes.get(childIdx++);
                    parent.right = rightChild;
                    if (rightChild != null) queue.offer(rightChild);
                }
            }
            levelIdx++;
        }

        return root;
    }
}
