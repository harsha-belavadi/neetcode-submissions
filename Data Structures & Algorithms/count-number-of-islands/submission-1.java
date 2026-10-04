class Solution {
    int n, m;
    int[][] visited;
    int[][] directions = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public int numIslands(char[][] grid) {
        n = grid.length;
        m = grid[0].length;
        visited = new int[n][m];
        int count = 0;
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (grid[i][j] == '1' && visited[i][j] == 0) {
                    dfs(i, j, grid);
                    count++;
                }
            }
        }
        return count;
    }

    private void dfs(int i, int j, char[][] grid) {
        if (i < 0 || i >= n || j < 0 || j >= m 
            || grid[i][j] == '0' || visited[i][j] == 1) {
            return;
        }
        
        visited[i][j] = 1;
        for (int[] dir : directions) {
            int r = i + dir[0];
            int c = j + dir[1];
            dfs(r, c, grid);
        }
    }
}
