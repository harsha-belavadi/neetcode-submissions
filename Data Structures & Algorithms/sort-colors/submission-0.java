class Solution {
    public void sortColors(int[] nums) {
        Map<Integer, Integer> counter = new HashMap<>() {{
            put(0, 0);
            put(1, 0);
            put(2, 0);
        }};
        for (int n : nums) {
            counter.put(n, counter.get(n) + 1);
        }

        int k = 0;
        for (int i=0; i<=2; i++) {
            for (int j=0; j<counter.get(i); j++) {
                nums[k] = i;
                k++;
            }
        }
    }
}