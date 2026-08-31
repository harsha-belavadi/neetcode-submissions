class Solution {
    private record MemoKey(int start, int k, long target) {}
    private Map<MemoKey, Set<List<Integer>>> memo = new HashMap<>();
    
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        return new ArrayList<>(kSum(nums, 0, (long)target, 4));
    }

    private Set<List<Integer>> kSum(int[] nums, int start, long target, int k) {
        MemoKey key = new MemoKey(start, k, target);
        if (memo.containsKey(key)) { return memo.get(key); }

        Set<List<Integer>> resultSet = new LinkedHashSet<>();
        
        if (start >= nums.length || nums.length - start < k) {
            return resultSet;
        }

        if (k == 2) { return twoSum(nums, start, target); }

        for (int i=start; i<nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) { continue; }
            
            long remaining = target - nums[i];
            Set<List<Integer>> subResults = kSum(nums, i+1, remaining, k-1);
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
        MemoKey key = new MemoKey(start, 2, target);
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        
        Set<List<Integer>> resultSet = new LinkedHashSet<>();
        int left = start;
        int right = nums.length - 1;

        while (left < right) {
            long sum = nums[left] + nums[right];
            if (sum == target) {
                List<Integer> subResult = new LinkedList<>();
                subResult.add(nums[left]);
                subResult.add(nums[right]);
                resultSet.add(subResult);
                left++;
                right--;
            } else if (sum > target) { right--; }
            else { left++; }
        }

        memo.put(key, resultSet);
        return resultSet;
    }
}