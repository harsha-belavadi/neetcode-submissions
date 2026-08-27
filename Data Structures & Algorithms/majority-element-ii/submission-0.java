class Solution {
    public List<Integer> majorityElement(int[] nums) {
        Map<Integer, Integer> counter = new HashMap<>();
        for (int num : nums) {
            counter.put(num, counter.getOrDefault(num, 0) + 1);
        }

        int n = nums.length;
        List<Integer> majority = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : counter.entrySet()) {
            if (entry.getValue() > n/3) {
                majority.add(entry.getKey());
            }
        }
        return majority;
    }
}