class Solution {
    int n = 0, m = 0;
    int[][] visited;
    private int[][] directions = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public int islandPerimeter(int[][] grid) {
        n = grid.length;
        m = grid[0].length;
        visited = new int[n][m]; 
        int totalPerimeter = 0;
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (grid[i][j] == 1) {
                    totalPerimeter += dfs(i, j, grid);
                }
            }
        }
        return totalPerimeter;
    }

    private int dfs(int i, int j, int[][] grid) {
        if (i < 0 || i >= n || j < 0 || j >= m || grid[i][j] == 0) {
            return 1;
        }

        if (visited[i][j] == 1) {
            return 0;
        }

        visited[i][j] = 1;
        int perimeter = 0;
        for (int[] dir : directions) {
            int r = i + dir[0];
            int c = j + dir[1];
            perimeter += dfs(r, c, grid);
        }

        return perimeter;
    }
}