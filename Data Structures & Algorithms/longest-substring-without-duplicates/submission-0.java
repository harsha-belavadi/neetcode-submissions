class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> charSet = new HashSet<>();
        int l = 0;
        int r = 0;
        int length = 0;
        while (r < s.length()) {
            char ch = s.charAt(r);
            while (charSet.contains(ch)) {
                charSet.remove(s.charAt(l));
                l++;
            }
            length = Math.max(length, r-l+1);
            charSet.add(ch);
            r++;
        }
        return length;
    }
}