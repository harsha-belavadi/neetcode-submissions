class Solution {
    public int firstMissingPositive(int[] nums) {
        Set<Integer> numset = new HashSet<>();
        for (int n : nums) {
            if (n < 0) { continue; } 
            numset.add(n);
        }

        // Solution will always be in range [1....len(Array) + 1]
        for (int i=1; i<=nums.length; i++) {
            if (!numset.contains(i)) {
                return i;
            }
        }

        return nums.length + 1;
    }
}