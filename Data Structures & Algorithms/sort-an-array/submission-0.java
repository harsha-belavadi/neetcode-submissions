class Solution {
    private int[] selectionsort(int[] nums) {
        int n = nums.length;
        for (int i=0; i<n; i++) {
            int mini = i;
            for (int j=i+1; j<n; j++) {
                if (nums[j] < nums[mini]) {
                    mini = j;
                }
            }
            int temp = nums[i];
            nums[i] = nums[mini];
            nums[mini] = temp;
        }
        return nums;
    }

    private int[] bubblesort(int[] nums) {
        int n = nums.length;
        boolean didSwap = false;
        for (int i=n-1; i>=0; i--) {
            for (int j=0; j<i; j++) {
                if (nums[j] > nums[i]) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                    didSwap = true;
                }
            }
            if (!didSwap) { return nums; }
        }
        return nums;
    }

    private int[] insertionsort(int[] nums) {
        int n = nums.length;
        for (int i=0; i<n; i++) {
            int j = i;
            while (j > 0 && nums[j-1] > nums[j]) {
                int temp = nums[j-1];
                nums[j-1] = nums[j];
                nums[j] = temp;
                j--;
            }
        }
        return nums;
    }

    public int[] sortArray(int[] nums) {
        return insertionsort(nums);
    }
}