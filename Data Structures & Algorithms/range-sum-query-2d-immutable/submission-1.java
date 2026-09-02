/*  Logic */
/* 

    Build prefix sum matrix:
    prefix[r][c] = prefix[r-1][c] + prefix[r][c-1] - prefix[r-1][c-1] + matrix[r-1][c-1]

    Find sum of region using the 1-indexed bottom-right cell with subtraction: 
    prefix[r2][c2] - prefix[r2][c1-1] - prefix[r1-1][c2] + prefix[r1-1][c1-1] 

*/
/* END */

class NumMatrix {
    private int[][] prefix;
    public NumMatrix(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return;
        int n = matrix.length;
        int m = matrix[0].length;
        prefix = new int[n+1][m+1];

        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                int r = i+1;
                int c = j+1;
                prefix[r][c] = prefix[r-1][c] + prefix[r][c-1] - prefix[r-1][c-1] + matrix[i][j];
            }
        }      
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        // Shift 0-indexed query coordinates to match 1-indexed prefix bounds
        int r1 = row1+1;
        int r2 = row2+1;
        int c1 = col1+1;
        int c2 = col2+1;

        // Execute the exact subtraction formula from the logic block
        return prefix[r2][c2] - prefix[r2][c1-1] - prefix[r1-1][c2] + prefix[r1-1][c1-1];
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */