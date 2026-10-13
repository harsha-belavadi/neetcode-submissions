/*
// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    
    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
}
*/

class Solution {
    public Node construct(int[][] grid) {
        return helper(grid, grid.length, 0, 0);
    }

    private Node helper(int[][] grid, int n, 
                        int r, int c) {
        boolean sameValue = true;
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                if (grid[r][c] != grid[r + i][c + j]) {
                    sameValue = false;
                    break;
                }
            }
        }

        if (sameValue) { // If true it is leaf node
            return new Node(grid[r][c] == 1, true);
        }

        n = n/2;
        Node topLeft = helper(grid, n, r, c);
        Node topRight = helper(grid, n, r, c + n);
        Node bottomLeft = helper(grid, n, r + n, c);
        Node bottomRight = helper(grid, n, r + n, c + n);

        return new Node(true, false, topLeft, topRight, bottomLeft, bottomRight); // Value wise you can pass anything for non-leaf
        // true or false is fine for non-leaf nodes
    }
}