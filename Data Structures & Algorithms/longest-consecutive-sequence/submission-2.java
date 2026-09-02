class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> numset = new HashSet<>();
        for (int n : nums) {
            numset.add(n);
        }

        int longest = 0;
        for (int n : nums) {
            if (numset.contains(n+1)) {
                continue;
            }
            int length = 1;
            while (numset.contains(n-1)) {
                length++;
                n = n-1;
            }
            longest = Math.max(longest, length);
        }
        return longest;
    }
}
