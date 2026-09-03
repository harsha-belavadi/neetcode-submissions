class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length-1;
        while (left < right) {
            int twosum = numbers[left] + numbers[right];
            if (twosum == target) {
                return new int[] { left + 1, right + 1 };
            } else if (twosum > target) { right--; }
            else { left++; } 
        }
        return new int[] { -1, -1 };
    }
}
