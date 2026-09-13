class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int boats = twosum(people, limit);
        int n = people.length;
        return boats + (n - boats * 2);
    }

    private int twosum(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int count = 0;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum <= target) {
                count++;
                left++;
                right--;
            } else { right--; }
        }
        return count;
    }
}