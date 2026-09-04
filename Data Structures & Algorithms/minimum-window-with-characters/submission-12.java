class Solution {
    Map<Character, Integer> counter = new HashMap<>();
    public String minWindow(String s, String t) {
        if (t.length() > s.length()) {
            return "";
        }
        
        for (char c : t.toCharArray()) {
            counter.put(c, counter.getOrDefault(c, 0) + 1);
        }

        int left = 0;
        int right = 0;
        int window = s.length();
        int startIndex = -1;

        while (right < s.length()) {
            char c1 = s.charAt(right);
            if (counter.containsKey(c1)) { 
                counter.put(c1, counter.get(c1) - 1);
            }
            while (isSubstr()) {
                if (right-left+1 <= window) {
                    window = right-left+1;
                    startIndex = left;
                }
                char c2 = s.charAt(left);
                if (counter.containsKey(c2)) {
                    counter.put(c2, counter.get(c2) + 1);
                }
                left++;
            }
            right++;
        }
        return startIndex == -1 ? "" : s.substring(startIndex, startIndex + window);
    }

    private boolean isSubstr() {
        for (int v : counter.values()) {
            if (v > 0) {
                return false;
            }
        }
        return true;
    }
}
