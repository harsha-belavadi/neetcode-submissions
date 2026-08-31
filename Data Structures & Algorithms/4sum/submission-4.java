class Solution {
    private Map<String, Set<List<Integer>>> memo = new HashMap<>();
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        int k = 4;
        int start = 0;
        return new ArrayList<>(ksumHelper(nums, start, (long)target, k));
    }

    private Set<List<Integer>> ksumHelper(int[] nums, int start, long target, int k) {
        Set<List<Integer>> resultSet = new LinkedHashSet<>();

        String key = start + "," + k + "," + target;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        if (start >= nums.length || nums.length - start < k) {
            return resultSet;
        }

        if (k == 2) { return twoSum(nums, start, target); }

        for (int i=start; i<nums.length; i++) {
            long remainingTarget = (long) target - nums[i];
            Set<List<Integer>> subResults = ksumHelper(nums, i+1, remainingTarget, k-1);
            for (List<Integer> subset : subResults) {
                List<Integer> list = new LinkedList<>();
                list.add(nums[i]);
                list.addAll(subset);
                resultSet.add(list);
            }
        }

        memo.put(key, resultSet);
        return resultSet;
    }

    private Set<List<Integer>> twoSum(int[] nums, int start, long target) {
        Set<List<Integer>> resultSet = new LinkedHashSet<>();
        int left = start;
        int right = nums.length - 1;
        while (left < right) {
            long sum = (long) nums[left] + nums[right];
            if (sum == target) {
                List<Integer> subResult = new LinkedList<>();
                subResult.add(nums[left]);
                subResult.add(nums[right]);
                resultSet.add(subResult);
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
