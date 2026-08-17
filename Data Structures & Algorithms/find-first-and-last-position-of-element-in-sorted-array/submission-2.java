class Solution {
    private int firstIndex(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int index = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
              index = mid;
              high = mid - 1;  
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return index;
    }

    private int lastIndex(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int index = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
              index = mid;
              low = mid + 1;  
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return index;
    }

    public int[] searchRange(int[] nums, int target) {
        // Use concept of upper bound and lower bound
        // lower bound - smallest element in the array >= x : ceil is same
        // upper bound - smallest element in the array > x
        // floor - largest element in the array <= x : not needed in this problem

        // Logic: find last index and last index by using lower bound logic with some modification to its logic => return 2 indices

        int lowerbound = firstIndex(nums, target);
        int upperbound = lastIndex(nums, target);
        return new int[] { lowerbound, upperbound };
    }
}