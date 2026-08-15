class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        List<List<Integer>> finalResult = new ArrayList<>();
        Arrays.sort(nums);
        for (int i=0; i<n; i++) {
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            int l = i+1;
            int r = nums.length - 1;
            while (l < r) {
                int threeSum = nums[i] + nums[l] + nums[r];
                if (threeSum < 0) {
                    l++;
                } else if (threeSum > 0) {
                    r--;
                } else {
                    finalResult.add(List.of(nums[i], nums[l], nums[r]));
                    l++;
                    while (l < r && nums[l] == nums[l - 1]) {
                        l++;
                        continue;
                    }
                }
            }
        }
        return finalResult;
    }
}
