class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        if (n == 0) return 0;

        int[][] cars = new int[n][2];
        for (int i=0; i<n; i++) {
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }

        // 1. Sort cars by starting position descending
        Arrays.sort(cars, (a, b) -> Integer.compare(b[0], a[0]));

        // 2. Calculate time using double
        double[] timeToReachDest = new double[n]; 
        for (int i=0; i<n; i++) {
            timeToReachDest[i] = (double) (target - cars[i][0]) / cars[i][1];
        }

        Stack<Double> pse = new Stack<>();
        for (double time : timeToReachDest) {
            // FIX: If the stack is empty, or the car behind takes MORE time 
            // than the fleet ahead, it forms a new independent fleet.
            if (pse.isEmpty() || time > pse.peek()) {
                pse.push(time);
            }
            // If time <= pse.peek(), it catches up and gets trapped behind 
            // the current fleet leader, so we safely do nothing.
        }
        
        return pse.size();
    }
}

/*
Trace iii) target=10, position=[0,4,2], speed=[2,1,3]
--------------------------------------------------
After sorting by position descending:
Row 0: pos = 4, speed = 1 -> time = (10-4)/1 = 6.0
Row 1: pos = 2, speed = 3 -> time = (10-2)/3 = 2.6666
Row 2: pos = 0, speed = 2 -> time = (10-0)/2 = 5.0

timeToReachDest = [6.0, 2.6666, 5.0]
pse = []

1. time = 6.0
   Stack is empty -> pse.push(6.0)
   pse = [6.0]

2. time = 2.6666
   Condition check: (2.6666 > 6.0) is FALSE.
   This car is faster and catches up to the 6.0 fleet, merging into it.
   Do nothing. pse remains = [6.0]

3. time = 5.0
   Condition check: (5.0 > 6.0) is FALSE.
   Even though 5.0 is slower than 2.6666, it is faster than the ultimate fleet leader (6.0) blocking the lane ahead. 
   It bumps into the fleet and merges.
   Do nothing. pse remains = [6.0]

End of loop. Return pse.size() -> 1 fleet (Correct!)
*/
