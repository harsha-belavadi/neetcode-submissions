class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int n = arr.length;
        int left = 0;
        int right = n - 1;
        
        while (right - left + 1 > k) {
            if (Math.abs(arr[left] - x) <= Math.abs(arr[right] - x)) {
                right--;
            } else {
                left++;
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int i=left; i<left + k; i++) {
            result.add(arr[i]);
        }
        return result;
    }
}