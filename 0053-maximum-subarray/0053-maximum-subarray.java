class Solution {
    public int maxSubArray(int[] nums) {
        return maxSubArraySum(nums, 0, nums.length-1);
    }

    public int maxSubArraySum(int[] nums, int left, int right) {
        if(left==right) {
            return nums[left];
        }

        int mid = left + (right-left)/2;
        int leftMaxSum = maxSubArraySum(nums, left, mid);
        int rightMaxSum = maxSubArraySum(nums, mid+1, right);
        int maxCrossingSum = crossingSum(nums, left, mid, right);

        return Math.max(Math.max(leftMaxSum, rightMaxSum), maxCrossingSum);
        
    }

    public int crossingSum(int[] nums, int left, int mid, int right) {
        int maxLeftSum = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = mid; i>=left; i--) {
            sum+=nums[i];
            maxLeftSum = Math.max(maxLeftSum, sum);
        }

        int maxRightSum = Integer.MIN_VALUE;
        sum = 0;
        for(int i=mid+1; i<=right; i++) {
            sum+=nums[i];
            maxRightSum = Math.max(maxRightSum, sum);
        }

        return maxRightSum + maxLeftSum;
    }
}