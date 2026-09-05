class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int left = 0;
        int right = 0;
        int window = 0;
        while (right < s.length()) {
            char c1 = s.charAt(right);
            while (set.contains(c1)) {
                set.remove(s.charAt(left));
                left++;
            }            
            set.add(c1);
            window = Math.max(window, right - left + 1);
            right++;
        }
        return window;
    }
}
