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
                if (nums[j] > nums[j+1]) {
                    int temp = nums[j+1];
                    nums[j+1] = nums[j];
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

    private int[] quicksort(int[] nums) {
        return quicksort(nums, 0, nums.length - 1);
    }

    private int[] quicksort(int[] nums, int low, int high) {
        if (low < high) {
            int partitionIndex = getPartitionIndex(nums, low, high);
            quicksort(nums, low, partitionIndex - 1);
            quicksort(nums, partitionIndex + 1, high);
        }
        return nums;
    }

    private int getPartitionIndex(int[] nums, int low, int high) {
        int left = low;
        int right = high;
        int pivot = nums[low];

        while (left < right) {
            while (left < high && nums[left] <= pivot) {
                left++;
            }

            while (right > low && nums[right] > pivot) {
                right--;
            }

            if (left < right) { swap(nums, left, right); }
        }

        swap(nums, low, right);
        return right; // pivot index
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public int[] sortArray(int[] nums) {
        return quicksort(nums);
    }
}