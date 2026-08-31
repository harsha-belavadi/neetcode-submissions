class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int n = numbers.length;
        int left = 0;
        int right = n - 1;
        
        int[] result = new int[2];
        while (left < right) {
            int twoSum = numbers[left] + numbers[right];
            if (twoSum == target) {
                result[0] = left + 1;
                result[1] = right + 1;
                break;
            } else if (twoSum > target) {
                right--;
            } else {
                left++;
            }
        }

        return result;
    }
}
