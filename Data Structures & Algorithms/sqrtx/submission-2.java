/* 
* WHY WE ONLY USE UPPERBOUND:
* LeetCode asks for the truncated (floor) integer square root.
* 
* For x = 8 (true sqrt ≈ 2.828, expected output = 2):
* - lowerbound looks for mid^2 >= 8 -> Returns 3 (3^2 = 9), which rounds UP.
* - upperbound looks for mid^2 <= 8 -> Returns 2 (2^2 = 4), which truncates DOWN.
* 
* For perfect squares like x = 9, both bounds return 3.
* Therefore, upperbound always yields the correct truncated integer.
*/
class Solution {
    private int upperbound(int x) {
        long low = 1;
        long high = x;
        long ub = -1;
        while (low <= high) {
            long mid = low + (high - low) / 2;
            long target = mid * mid;
            if (target <= x) { 
                ub = mid;
                low = mid + 1; 
            } else {
                high = mid - 1;
            }
        }
        return (int)ub;
    }

    public int mySqrt(int x) {
        if (x == 0) return 0;
        
        return upperbound(x);
    }
}