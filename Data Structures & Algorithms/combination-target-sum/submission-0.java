class Solution {
    private int[] nums;
    private List<Integer> partition = new ArrayList<>();
    private List<List<Integer>> output = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        this.nums = nums;
        backtrack(0, 0, target);
        return output;
    }

    private void backtrack(int i, int sum, int target) {
        if (sum >= target) {
            if (sum == target) {
                output.add(new ArrayList<>(partition));
            }
            return;
        }

        for (int j=i; j<nums.length; j++) {
            partition.add(nums[j]);
            sum += nums[j];
            backtrack(j, sum, target);
            partition.removeLast();
            sum -= nums[j];
        }
    } 
}
