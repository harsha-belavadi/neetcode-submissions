class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();
        Arrays.sort(nums);

        int n = nums.length;
        for (int i=0; i<n; i++) {
            int left = i+1;
            int right = n - 1;
            while (left < right) {
                int threesum = nums[i] + nums[left] + nums[right];
                if (threesum == 0) {
                    result.add(List.of(nums[i], nums[left], nums[right]));
                    left++;
                    right--;
                } else if (threesum > 0) {
                    right--;
                } else {
                    left++;
                }
            }
        }

        return new ArrayList<>(result);
    }
}
