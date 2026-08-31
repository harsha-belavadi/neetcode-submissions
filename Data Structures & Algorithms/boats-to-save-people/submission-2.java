class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int boats = twoSum(people, 0, limit, 0);
        return boats + (people.length - (2 * boats));
    }

    private int twoSum(int[] people, int start, int target, int boats) {
        int left = start;
        int right = people.length - 1;
        while (left < right) {
            int sum = people[left] + people[right];
            if (sum <= target) {
                left++;
                right--;                
                boats++;
            } else { right--; }
        }
        return boats;
    }
}