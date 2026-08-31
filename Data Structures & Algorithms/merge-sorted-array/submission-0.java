class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = 0;
        int j = 0;
        int k = 0;
        int[] newNums = new int[m + n];

        while (i < m && j < n) {
            if (nums1[i] <= nums2[j]) {
                newNums[k] = nums1[i];
                i++;
                k++;
            } else {
                newNums[k] = nums2[j]; 
                j++;
                k++;
            }
        }

        while (i < m) {
            newNums[k] = nums1[i];
            i++;
            k++;
        }

        while (j < n) {
            newNums[k] = nums2[j]; 
            j++;
            k++;
        }

        for (int idx=0; idx<(m + n); idx++) {
            nums1[idx] = newNums[idx];
        }
    }
}