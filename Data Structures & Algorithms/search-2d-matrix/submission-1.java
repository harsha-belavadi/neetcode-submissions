class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int low = 0;
        int high = matrix.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int k = matrix[mid].length - 1;
            if (target < matrix[mid][0]) {
                high = mid - 1;
            } else if (target > matrix[mid][k]) {
                low = mid + 1;
            } else {
                return binarySearch(matrix[mid], target);
            }
        }
        return false;
    }

    private boolean binarySearch(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (target < nums[mid]) {
                high = mid - 1;
            } else if (target > nums[mid]) {
                low = mid + 1;
            } else {
                return true;
            }
        }
        return false;
    }
}
