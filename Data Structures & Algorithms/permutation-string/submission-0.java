class Solution {
    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> s1map = new HashMap<>();
        Map<Character, Integer> s2map = new HashMap<>();

        int n = s1.length();
        int m = s2.length();

        if (n > m) { return false; }

        for (int i=0; i<n; i++) {
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);
            s1map.put(c1, s1map.getOrDefault(c1, 0) + 1);
            s2map.put(c2, s2map.getOrDefault(c2, 0) + 1);
        }

        if (s1map.equals(s2map)) {
            return true;
        }

        int l = 0;
        for (int r=n; r<m; r++) {
            char c_r = s2.charAt(r);
            s2map.put(c_r, s2map.getOrDefault(c_r, 0) + 1);

            char c_l = s2.charAt(l);
            s2map.put(c_l, s2map.get(c_l) - 1);
            if (s2map.get(c_l) == 0) {
                s2map.remove(c_l);
            }

            if (s1map.equals(s2map)) {
                return true;
            }
            l++;
        }
        return false;
    }
}
