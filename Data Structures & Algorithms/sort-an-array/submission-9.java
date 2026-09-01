static class Sort {
    int[] nums;
    Sort(Builder builder) {
        this.nums = builder.nums;
    }

    public int[] getSorted() {
        return this.nums;
    }

    public static class Builder {
        private int[] nums;

        public Builder selectionsort(int[] nums) {
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
            setNums(nums);
            return this;
        }

        public Builder bubblesort(int[] nums) {
            int n = nums.length;
            boolean didSwap = false;
            outer:
            for (int i=n-1; i>=0; i--) {
                for (int j=0; j<i; j++) {
                    if (nums[j] > nums[j+1]) {
                        int temp = nums[j];
                        nums[j] = nums[j+1];
                        nums[j+1] = temp;
                        didSwap = true;
                    }
                }
                if (!didSwap) { break outer; }
            }

            setNums(nums);
            return this;
        }

        public Builder insertionsort(int[] nums) {
            for (int i=0; i<nums.length; i++) {
                int j = i;
                while (j > 0 && nums[j-1] > nums[j]) {
                    int temp = nums[j-1];
                    nums[j-1] = nums[j];
                    nums[j] = temp;
                    j--;
                }
            }
            setNums(nums);
            return this;
        }

        public Builder quicksort(int[] nums) {
            setNums(quicksort(nums, 0, nums.length - 1));
            return this;
        }

        public Builder mergesort(int[] nums) {
            performMergesort(nums);
            setNums(nums);
            return this;
        }

        public int[] apply() {
            return new Sort(this).getSorted();
        }

        private int[] quicksort(int[] nums, int low, int high) {
            if (low < high) {
                int partitionIdx = partition(nums, low, high);
                quicksort(nums, low, partitionIdx - 1);
                quicksort(nums, partitionIdx + 1, high);
            }
            return nums;
        }

        private int partition(int[] nums, int low, int high) {
            int pivot = nums[low];
            int left = low;
            int right = high;

            while (left < right) {
                while (left < high && nums[left] <= pivot) { left++; }
                while (right > low && nums[right] > pivot) { right--; }
                if (left < right) {
                    int temp = nums[left];
                    nums[left] = nums[right];
                    nums[right] = temp;
                }
            }

            int temp = nums[low];
            nums[low] = nums[right];
            nums[right] = temp;

            return right;
        }

        private void performMergesort(int[] nums) {
            if (nums.length <= 1) { return; }
            
            int mid = nums.length / 2;
            int[] left = new int[mid];
            int[] right = new int[nums.length - mid];

            for (int i=0; i<mid; i++) {
                left[i] = nums[i];
            }

            for (int i=mid; i<nums.length; i++) {
                right[i - mid] = nums[i];
            }

            performMergesort(left);
            performMergesort(right);
            merge(nums, left, right);
        }

        private void merge(int[] nums, int[] left, int[] right) {
            int i = 0;
            int j = 0;
            int k = 0;

            while (i < left.length && j < right.length) {
                if (left[i] <= right[j]) {
                    nums[k] = left[i];
                    i++;
                } else {
                    nums[k] = right[j];
                    j++;
                }
                k++;
            }

            while (i < left.length) {
                nums[k] = left[i];
                k++;
                i++;
            }

            while (j < right.length) {
                nums[k] = right[j];
                k++;
                j++;
            }
        }

        private void setNums(int[] nums) {
            this.nums = nums;
        }

    }
}

class Solution {
    public int[] sortArray(int[] nums) {
        return new Sort.Builder().mergesort(nums).apply();
    }
}