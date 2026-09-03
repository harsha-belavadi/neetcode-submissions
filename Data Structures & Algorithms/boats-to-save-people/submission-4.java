class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int boatsForTwo = twosum(people, limit);
        return boatsForTwo + (people.length - (2 * boatsForTwo));       
    }

    private int twosum(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int boats = 0;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum <= target) {
                left++;
                right--;
                boats++;
            } else { right--; }
        }
        return boats;
    }
}