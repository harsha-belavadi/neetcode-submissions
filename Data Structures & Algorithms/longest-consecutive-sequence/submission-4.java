class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) { return 0; }
        
        Set<Integer> set = new HashSet<>();
        for (int n : nums) {
            set.add(n);
        }
        int longest = 1;
        for (int n : nums) {
            int count = 1;
            if (set.contains(n+1)) { continue; }
            int value = n-1;
            while (set.contains(value)) {
                value--;
                count++;
            }
            longest = Math.max(longest, count);
        }
        return longest;
    }
}
