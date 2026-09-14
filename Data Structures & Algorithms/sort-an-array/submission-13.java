static class Sort {
    int[] nums;
    private Sort(Builder builder) {
        this.nums = builder.nums;
    }

    public int[] get() {
        return nums;
    }

    public static class Builder {
        private int[] nums;
        public Builder mergesort(int[] nums) {
            run_mergesort(nums);
            save(nums);      
            return this;
        }

        private void run_mergesort(int[] nums) {
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

            run_mergesort(left);
            run_mergesort(right);
            merge(nums, left, right);
        }

        private void merge(int[] nums, int[] left, int[] right) {
            int n = left.length;
            int m = right.length;
            int i = 0;
            int j = 0;
            int k = 0;
            while (i < n && j < m) {
                if (left[i] <= right[j]) {
                    nums[k++] = left[i++];
                } else {
                    nums[k++] = right[j++];
                }
            }

            while (i < n) {
                nums[k++] = left[i++];
            }

            while (j < m) {
                nums[k++] = right[j++];
            }
        }

        private Builder quicksort(int[] nums) {
            quicksort(nums, 0, nums.length-1);
            save(nums);
            return this;
        }

        private void quicksort(int[] nums, int low, int high) {
            if (low < high) {
                int pidx = partition(nums, low, high); 
                quicksort(nums, low, pidx-1);
                quicksort(nums, pidx+1, high); 
            }
        }

        private int partition(int[] nums, int low, int high) {
            int pivot = nums[low];
            int left = low;
            int right = high;
            while (left < right) {
                while (left <= high && nums[left] <= pivot) {
                    left++;
                }
                while (right >= 0 && nums[right] > pivot) {
                    right--;
                }
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
            save(nums);
            return this;
        }

        public Builder bubblesort(int[] nums) {
            int n = nums.length;
            boolean sorted = true;
            outer:
            for (int i=n-1; i>=0; i--) {
                for (int j=0; j<i; j++) {
                    if (nums[j] > nums[j+1]) {
                        int temp = nums[j];
                        nums[j] = nums[j+1];
                        nums[j+1] = temp;
                        sorted = false;
                    }
                }
                if (sorted) { break outer; }
            }

            save(nums);
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
            save(nums);
            return this;
        }

        public int[] apply() {
            return new Sort(this).get();
        }

        private void save(int[] nums) {
            this.nums = nums;
        }
    }
}

class Solution {
    public int[] sortArray(int[] nums) {
        return new Sort.Builder().quicksort(nums).apply();
    }
}