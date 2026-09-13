class Solution {
    Map<String, Set<List<Integer>>> memo = new HashMap<>();
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        return new ArrayList<>(ksum(nums, 0, (long)target, 4));
    }

    private Set<List<Integer>> ksum(int[] nums, int start, long target, int k) {
        String key = String.format("%s%s%s", start, k, target);
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        if (k == 2) { return twoSum(nums, start, target); }
        
        Set<List<Integer>> result = new HashSet<>();
        for (int i=start; i<nums.length; i++) {
            long remaining = target - nums[i];
            Set<List<Integer>> subresults = ksum(nums, i+1, remaining, k-1);
            for (List<Integer> subset : subresults) {
                List<Integer> list = new ArrayList<>();
                list.add(nums[i]);
                list.addAll(subset);
                result.add(list);
            }
        }
        memo.put(key, result);
        return result;
    }

    private Set<List<Integer>> twoSum(int[] nums, int start, long target) {
        Set<List<Integer>> result = new HashSet<>();
        int left = start;
        int right = nums.length-1;
        while (left < right) {
            long sum = nums[left] + nums[right];
            if (sum == target) {
                result.add(List.of(nums[left], nums[right]));
                left++;
                right--;
            } else if (sum > target) {
                right--;
            } else {
                left++;
            }
        }
        return result;
    }
}