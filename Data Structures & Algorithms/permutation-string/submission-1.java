class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) { return false; }
        Map<Character, Integer> s1Map = new HashMap<>();
        Map<Character, Integer> s2Map = new HashMap<>();

        for (int i=0; i<s1.length(); i++) {
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);
            s1Map.put(c1, s1Map.getOrDefault(c1, 0) + 1);
            s2Map.put(c2, s2Map.getOrDefault(c2, 0) + 1);
        }

        if (s1Map.equals(s2Map)) { return true; }

        int left = 0;
        int right = s1.length();
        while (right < s2.length()) {
            char c1 = s2.charAt(right);
            s2Map.put(c1, s2Map.getOrDefault(c1, 0) + 1);
            int window = right - left + 1;
            while (window > s1.length()) {
                char c2 = s2.charAt(left);
                s2Map.put(c2, s2Map.get(c2) - 1);
                if (s2Map.get(c2) == 0) {
                    s2Map.remove(c2);
                }
                left++;
                window = right - left + 1;
            }
            if (window == s1.length() && s1Map.equals(s2Map)) {
                return true;
            }
            right++;
        }
        return false;
    }
}
