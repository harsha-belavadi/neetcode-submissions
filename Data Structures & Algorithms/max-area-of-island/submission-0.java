class Solution {
    int n = 0, m = 0;
    int[][] visited;
    private int[][] directions = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public int maxAreaOfIsland(int[][] grid) {
        n = grid.length;
        m = grid[0].length;
        visited = new int[n][m]; 
        int maxPerimeter = 0;
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (grid[i][j] == 1 && visited[i][j] == 0) {
                    maxPerimeter = Math.max(maxPerimeter, dfs(i, j, grid));
                }
            }
        }
        return maxPerimeter;
    }

    private int dfs(int i, int j, int[][] grid) {
        if (i < 0 || i >= n || j < 0 || j >= m 
            || grid[i][j] == 0 || visited[i][j] == 1) {
            return 0;
        }

        visited[i][j] = 1;
        int area = 1;
        for (int[] dir : directions) {
            int r = i + dir[0];
            int c = j + dir[1];
            area += dfs(r, c, grid);
        }

        return area;
    } 
}
