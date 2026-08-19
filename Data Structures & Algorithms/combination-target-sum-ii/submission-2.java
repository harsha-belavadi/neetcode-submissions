class Solution {
    private int[] nums;
    private List<Integer> partition = new ArrayList<>();
    private List<List<Integer>> output = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates); 
        this.nums = candidates;
        backtrack(0,target);
        return output;    
    }

    private void backtrack(int i, int target) {
        if (target == 0) {
            output.add(new ArrayList<>(partition));
            return;
        }
        
        if (target < 0) { return; }

        for (int j=i; j<nums.length; j++) {
            if (j > i && nums[j] == nums[j - 1]) { continue; }
            if (nums[i] > target) { break; }
            partition.add(nums[j]);
            backtrack(j+1, target - nums[j]);
            partition.removeLast();
        }
    } 
}
