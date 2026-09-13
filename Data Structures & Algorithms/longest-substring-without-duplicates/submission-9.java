class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int n = s.length();
        int left = 0;
        int right = 0;
        int longest = 0;
        while (right < n) {
            char c1 = s.charAt(right);            
            while (left < right && set.contains(c1)) {
                char c2 = s.charAt(left);
                set.remove(c2);
                left++;
            }
            int window = right - left + 1;
            set.add(c1);
            longest = Math.max(longest, window);
            right++;
        }
        return longest;
    }
}
