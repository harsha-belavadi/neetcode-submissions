class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int l = 0;
        int r = numbers.length-1;
        while (l < r) {
            int twoSum = numbers[l] + numbers[r];
            if (twoSum > target) {
                r--;
            } else if (twoSum < target) {
                l++;
            } else {
                break;
            }
        }
        return new int[] {l+1, r+1};
    }
}
