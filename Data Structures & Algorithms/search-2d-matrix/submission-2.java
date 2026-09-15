/*
The Formulas (0-Indexed)

Row = cell / cols (Integer division drops the remainder)

Col = cell % cols (The modulo operator keeps only the remainder)

*/
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int n = rows * cols;
        int low = 0;
        int high = n-1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int r = mid / cols;
            int c = mid % cols;
            if (matrix[r][c] == target) { return true; }
            else if (matrix[r][c] > target) { high = mid - 1; }
            else { low = mid + 1; }
        }
        return false;
    }
}
