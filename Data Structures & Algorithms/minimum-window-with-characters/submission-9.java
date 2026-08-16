class Solution {
    public String minWindow(String s, String t) {
        if (s.equals(t)) { return s; }

        Map<Character, Integer> counter = new HashMap<>();        
        int n = t.length();
        int m = s.length();

        for (int i=0; i<n; i++) {
            char c = t.charAt(i);
            counter.put(c, counter.getOrDefault(c, 0) + 1);
        }

        int l = 0;
        int count = 0;
        int startIndex = -1;
        int minLength = m;
        for (int r = 0; r < m; r++) {
            char c = s.charAt(r);
            counter.put(c, counter.getOrDefault(c, 0) - 1);
            if (counter.get(c) >= 0) { count++; } // Because one character can appear multiple times in target hence we should have >=
            while (count == n) {
                c = s.charAt(l);
                counter.put(c, counter.get(c) + 1);
                if (counter.get(c) > 0) { count--; }
                if (r-l+1 <= minLength) { // If minLength is equal to m then problem is startIndex will remain -1 if we don't have <=
                    startIndex = l;
                    minLength = r-l+1;
                }
                l++;
            }
        }
        return startIndex == -1 ? "" : s.substring(startIndex, startIndex + minLength);
    }
}
