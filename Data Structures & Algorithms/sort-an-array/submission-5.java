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

    private int[] quicksort(int[] nums, int lowIndex, int highIndex) {
        if (lowIndex >= highIndex) {
            return nums;
        }

        int pivot = nums[highIndex];

        // Start pointers outside the range so the do-while loop increments them correctly
        int leftPointer = lowIndex - 1;
        int rightPointer = highIndex; 

        while (true) {
            // Move right until finding an element >= pivot
            do {
                leftPointer++;
            } while (nums[leftPointer] < pivot);

            // Move left until finding an element <= pivot
            do {
                rightPointer--;
            } while (rightPointer > lowIndex && nums[rightPointer] > pivot);

            // If pointers cross, the partitioning is complete
            if (leftPointer >= rightPointer) {
                break;
            }

            // Swap the misplaced elements
            int temp = nums[leftPointer];
            nums[leftPointer] = nums[rightPointer];
            nums[rightPointer] = temp;
        }
        
        // Put the pivot into its correct final position
        int temp = nums[highIndex]; 
        nums[highIndex] = nums[leftPointer]; 
        nums[leftPointer] = temp;

        // Recursively sort the sub-arrays
        quicksort(nums, lowIndex, leftPointer - 1);
        quicksort(nums, leftPointer + 1, highIndex);

        return nums;
    }

    public int[] sortArray(int[] nums) {
        return quicksort(nums);
    }
}