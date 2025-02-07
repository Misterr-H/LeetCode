class Solution {
    public int maximumRobots(int[] chargeTimes, int[] runningCosts, long budget) {
        int result = 0;
        int left = 0;
        Deque<Integer> q = new ArrayDeque<>();
        int n = chargeTimes.length;

        long maxSum = 0;

        for(int right = 0; right<n; right++) {
            while(!q.isEmpty() && chargeTimes[q.peekLast()] <= chargeTimes[right]) {
                q.pollLast();
            }
            q.offerLast(right);
            int k = right - left + 1;
            maxSum += runningCosts[right];

            while(!q.isEmpty() && (chargeTimes[q.peekFirst()] + k*maxSum > budget)) {
                if(q.peekFirst() == left) q.pollFirst();
                maxSum -= runningCosts[left];
                left++;
                k--;
            }

            result = Math.max(k, result);

        }

        return result;

    }
}