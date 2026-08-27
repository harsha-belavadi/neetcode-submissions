class Solution {
    public int[] getConcatenation(int[] nums) {
        int n = nums.length;
        int[] ans = new int[2 * n];
        for (int i=0; i<2*n; i++) {
            int idx = i % n;
            ans[i] = nums[idx];
        }
        return ans;
    }
}