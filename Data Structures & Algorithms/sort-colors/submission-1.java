class Solution {
    public void sortColors(int[] nums) {
        int[] bucket = new int[3];
        for (int n : nums) { bucket[n]++; }
        int k=0;
        for (int i=0; i<3; i++) {
            while (bucket[i] > 0) {
                nums[k] = i;
                k++;
                bucket[i]--;
            }
        }
    }
}