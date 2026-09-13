class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) { return false; }
        Map<Character, Integer> counter = new HashMap<>();
        for (int i=0; i<s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            counter.put(c1, counter.getOrDefault(c1, 0) + 1);
            counter.put(c2, counter.getOrDefault(c2, 0) - 1);
        }
        for (int value : counter.values()) {
            if (value != 0) {
                return false;
            }
        }
        return true;
    }
}
