class Solution {
    
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        int k = 4;
        return new ArrayList<>(kSumHelper(nums, 0, k, (long)target));
    }

    private Set<List<Integer>> kSumHelper(int[] nums, int start, int k, long target) {
        Set<List<Integer>> resultSet = new LinkedHashSet<>();

        if (start >= nums.length || nums.length-start < k) {
            return new LinkedHashSet<>();
        }

        if (k == 2) {
            return twoSum(nums, start, target);
        }

        for (int i=start; i<nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            Set<List<Integer>> subResult = kSumHelper(nums, i+1, k-1, target - nums[i]);
            for (List<Integer> subset : subResult) {
                List<Integer> list = new ArrayList<>();
                list.add(nums[i]);
                list.addAll(subset);
                resultSet.add(list);
            }
        }
        return resultSet;
    }

    private Set<List<Integer>> twoSum(int[] nums, int start, long target) {
        int left = start;
        int right = nums.length - 1;
        Set<List<Integer>> resultSet = new LinkedHashSet<>();
        while (left < right) {
            long sum = (long) nums[left] + nums[right];
            if (sum == target) {
                List<Integer> pair = new ArrayList<>();
                pair.add(nums[left]);
                pair.add(nums[right]);
                resultSet.add(pair);
                left++;
                right--;
            } else if (sum > target) {
                right--;
            } else {
                left++;
            }
        }
        return resultSet;
    }
}