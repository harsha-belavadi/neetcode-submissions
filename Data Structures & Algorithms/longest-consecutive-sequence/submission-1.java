class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) { numSet.add(num); }

        int longest = 0;
        for (int num : nums) {
            if (numSet.contains(num - 1)) { continue; }
            numSet.add(num);
            int n = num + 1;
            int length = 1;
            while (numSet.contains(n)) {
                length += 1;
                n++;
            }

            longest = Math.max(longest, length);
        }
        return longest;
    }
}
