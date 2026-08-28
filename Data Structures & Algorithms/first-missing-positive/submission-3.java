class Solution {
    public int firstMissingPositive(int[] nums) {
        Set<Integer> numset = new HashSet<>();
        for (int n : nums) {
            if (n < 0) { continue; } 
            numset.add(n);
        }

        for (int i=1; i<=nums.length+1; i++) {
            if (!numset.contains(i)) {
                return i;
            }
        }

        return 0;
    }
}