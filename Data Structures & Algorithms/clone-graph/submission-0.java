/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    Map<Node, Node> deepcopy = new HashMap<>() {{
        put(null, null);
    }};
    public Node cloneGraph(Node node) {
        dfs(node);
        return deepcopy.get(node);
    }

    private void dfs(Node node) {
        if (deepcopy.containsKey(node)) return;
        deepcopy.put(node, new Node(node.val, new ArrayList<>()));
        for (Node neighbor : node.neighbors) {
            if (!deepcopy.containsKey(neighbor)) {
                dfs(neighbor);
            }
            deepcopy.get(node).neighbors.add(deepcopy.get(neighbor));
        }
    }
}