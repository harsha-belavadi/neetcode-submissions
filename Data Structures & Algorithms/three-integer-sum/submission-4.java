class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> result = new HashSet<>();
        for (int i=0; i<nums.length; i++) {
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }

            int left = i+1;
            int right = nums.length-1;
            while (left < right) {
                int threesum = nums[i] + nums[left] + nums[right];
                if (threesum == 0) {
                    result.add(List.of(nums[i], nums[left], nums[right]));
                    left++;
                    right--;
                } else if (threesum > 0) { right--; }
                else { left++; }
            }
        }

        return new ArrayList<>(result);
    }
}
