class Solution {
    private Map<String, Set<List<Integer>>> memo = new HashMap<>();
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        return new ArrayList<>(ksum(nums, 0, (long)target, 4));
    }

    private Set<List<Integer>> ksum(int[] nums, int start, long target, int k) {
        String key = start + "," + k + "," + target;
        if (memo.containsKey(key)) { return memo.get(key); }
        if (k == 2) { return twosum(nums, start, target); }
        
        Set<List<Integer>> result = new LinkedHashSet<>();
        for (int i=start; i<nums.length; i++) {
            long remaining = target - nums[i];
            Set<List<Integer>> subResults = ksum(nums, i+1, remaining, k-1);
            for (List<Integer> subset : subResults) {
                List<Integer> list = new ArrayList<>();
                list.add(nums[i]);
                list.addAll(subset);
                result.add(list);
            }
        }

        memo.put(key, result);
        return result;
    }

    private Set<List<Integer>> twosum(int[] nums, int start, long target) {
        int left = start;
        int right = nums.length-1;
        Set<List<Integer>> result = new LinkedHashSet<>();
        while (left < right) {
            long total = nums[left] + nums[right];
            if (total == target) {
                result.add(List.of(nums[left], nums[right]));
                left++;
                right--;
            } else if (total > target) { right--; }
            else { left++; }
        }
        return result;
    }
}