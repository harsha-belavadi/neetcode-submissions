class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> counter = new HashMap<>();
        for (int n : nums) {
            counter.put(n, counter.getOrDefault(n, 0) + 1);
        }

        Map<Integer, List<Integer>> frequencies = new HashMap<>();
        int maxCount = Integer.MIN_VALUE;
        for (Map.Entry<Integer, Integer> entry : counter.entrySet()) {
            int n = entry.getKey();
            int count = entry.getValue();
            if (!frequencies.containsKey(count)) { 
                frequencies.put(count, new ArrayList<>());
            }
            frequencies.get(count).add(n);
            maxCount = Math.max(maxCount, count);
        }

        List<Integer> kelements = new LinkedList<>();
        outer:
        for (int i=maxCount; i>=1; i--) {
            if (frequencies.containsKey(i)) {
                for (int element : frequencies.get(i)) {
                    kelements.add(element);
                    k--;
                    if (k == 0) {
                        break outer;
                    }
                }
            }
        }

        return kelements.stream()
                        .mapToInt(Integer::intValue)
                        .toArray();
    }
}
