class Solution {
    public int orangesRotting(int[][] grid) {
        int[][] directions = new int[][] {
            {0, 1}, {0, -1}, {1, 0}, {-1, 0}
        };

        int n = grid.length;
        int m = grid[0].length;

        int fresh = 0;
        Queue<int[]> queue = new LinkedList<>();
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[] {i, j});
                } else if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        int minute = 0;
        while (!queue.isEmpty() && fresh > 0) {
            int size = queue.size();
            for (int i=0; i<size; i++) {
                int[] current = queue.poll();
                for (int[] dir : directions) {
                    int r = current[0] + dir[0];
                    int c = current[1] + dir[1];
                    if (r < 0 || r >= n || 
                        c < 0 || c >= m ||
                        grid[r][c] == 2 ||
                        grid[r][c] == 0) {
                        continue;
                    }
                    grid[r][c] = 2;
                    fresh--;
                    queue.offer(new int[] { r, c });
                }
            }
            minute++;
        }

        return fresh == 0 ? minute : -1;
    }
}
