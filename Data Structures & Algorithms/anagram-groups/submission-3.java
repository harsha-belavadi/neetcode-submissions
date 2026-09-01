class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> groups = new HashMap<>();
        for (int i=0; i<strs.length; i++) {
            int[] bucket = new int[128];
            for (int j=0; j<strs[i].length(); j++) {
                char c = strs[i].charAt(j);
                bucket[c]++;
            }
            String key = Arrays.toString(bucket);
            if (!groups.containsKey(key)) {
                groups.put(key, new ArrayList<>());
            }
            groups.get(key).add(strs[i]);
        }

        List<List<String>> result = new ArrayList<>();
        for (List<String> group : groups.values()) {
            result.add(group);
        }

        return result;
    }
}
