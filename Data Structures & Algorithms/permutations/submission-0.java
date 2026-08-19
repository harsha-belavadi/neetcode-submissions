class Solution {
    private int[] nums;
    private List<Integer> partition = new ArrayList<>();
    private List<List<Integer>> output = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        this.nums = nums;
        partition = new ArrayList<>();
        output = new ArrayList<>();
        backtrack();
        return output;
    }

    private void backtrack() {
        if (partition.size() == nums.length) {
            output.add(new ArrayList<>(partition));
            return;
        }
        for (int j=0; j<nums.length; j++) {
            if (partition.contains(nums[j])) { continue; }
            partition.add(nums[j]);
            backtrack();
            partition.removeLast();
        }
    }
}
