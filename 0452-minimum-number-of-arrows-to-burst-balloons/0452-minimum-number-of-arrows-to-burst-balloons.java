class Solution {
    public int findMinArrowShots(int[][] points) {
        if (points == null || points.length == 0) {
            return 0;
        }
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1])); // we cannot use (a,b) -> a[1] - b[1] cause arithmetic substraction leads to integer overflow for extreme int cases
        int[] currBalloon = points[0];
        int minArrows = 1;
        for(int i=1; i < points.length; i++) {
            if(points[i][0] > currBalloon[1]) {
                minArrows++;
                currBalloon = points[i];
            }
        }
        return minArrows;
    }
}