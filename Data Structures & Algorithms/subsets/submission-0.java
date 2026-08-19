class Solution {
    private int[] nums;
    private List<Integer> partition = new ArrayList<>();
    private List<List<Integer>> output = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        this.nums = nums;
        partition = new ArrayList<>();
        output = new ArrayList<>();
        backtrack(0);
        return output;
    }

    private void backtrack(int i) {
        output.add(new ArrayList<>(partition));
        for (int j=i; j<nums.length; j++) {
            partition.add(nums[j]);
            backtrack(j+1);
            partition.removeLast();
        }
    }
}
