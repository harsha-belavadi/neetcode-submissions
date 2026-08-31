class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> resultSet = new LinkedHashSet<>();
        for (int i=0; i<nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) { continue; }
            int left = i+1;
            int right = nums.length - 1;
            while (left < right) {
                int threeSum = nums[i] + nums[left] + nums[right];
                if (threeSum == 0) {
                    resultSet.add(List.of(nums[i], nums[left], nums[right]));
                    left++;
                    right--;
                } else if (threeSum > 0) { right--; }
                else { left++; }
            }
        }
        return new ArrayList<>(resultSet);
    }
}
