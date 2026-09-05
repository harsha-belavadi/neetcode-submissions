class Solution {
    Map<Character, Integer> counter = new HashMap<>();
    public String minWindow(String s, String t) {
        if (t.length() > s.length()) { return ""; }
        for (int i=0; i<t.length(); i++) {
            char ch = t.charAt(i);
            counter.put(ch, counter.getOrDefault(ch, 0) + 1);
        }
        
        int left = 0;
        int right = 0;
        int minWindow = s.length();
        int start = -1;
        while (right < s.length()) {
            char c1 = s.charAt(right);
            if (counter.containsKey(c1)) {
                counter.put(c1, counter.get(c1) - 1);
            }
            int window = right - left + 1;
            while (isSubstr()) {
                if (window <= minWindow) {
                    minWindow = window;
                    start = left;
                }
                char c2 = s.charAt(left);
                if (counter.containsKey(c2)) {
                    counter.put(c2, counter.get(c2) + 1);
                }
                left++;
                window = right - left + 1;
            }
            right++;
        }
        return start == -1 ? "" : s.substring(start, start + minWindow);
    }

    private boolean isSubstr() {
        for (int v : counter.values()) {
            if (v > 0) { return false; }
        }
        return true;
    }
}
