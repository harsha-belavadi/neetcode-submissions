class Solution {
    public int firstMissingPositive(int[] nums) {
        Set<Integer> numset = new HashSet<>();
        for (int n : nums) {
            if (n < 0) { continue; } 
            numset.add(n);
        }

        int result = 1;
        while (true) {
            if (!numset.contains(result)) {
                break;
            }
            result++;
        }

        return result;
    }
}