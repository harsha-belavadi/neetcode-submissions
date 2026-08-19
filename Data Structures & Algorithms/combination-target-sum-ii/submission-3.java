class Solution {
    private int[] nums;
    private List<Integer> partition = new ArrayList<>();
    private List<List<Integer>> output = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        this.nums = candidates;
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
            if (j > i && nums[j] == nums[j - 1]) { continue; }
            if (sum + nums[j] > target) { break; }
            partition.add(nums[j]);
            sum += nums[j];
            backtrack(j+1, sum, target);
            partition.removeLast();
            sum -= nums[j];
        }
    } 
}
