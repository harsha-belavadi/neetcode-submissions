class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        Stack<Double> stack = new Stack<>();
        int[][] cars = new int[position.length][2];
        for (int i=0; i<position.length; i++) {
            int pos = position[i];
            int spd = speed[i];
            cars[i][0] = pos;
            cars[i][1] = spd;
        }

        Arrays.sort(cars, (a, b) -> b[0] - a[0]);
        for (int i=0; i<cars.length; i++) {
            double time = (double) (target - cars[i][0]) / cars[i][1];
            if (!stack.isEmpty() && time <= stack.peek()) {
                continue;
            }
            stack.push(time);
        }

        return stack.size();
    }
}

/*

0,1 -> 10
1,2 -> 5
4,2 -> 3
7,1 -> 3

set: => 3 unique elements -> output
10
5
3
3
*/