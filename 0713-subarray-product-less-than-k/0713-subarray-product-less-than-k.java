class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k==0)
            return 0;
        int count = 0;
        int prod = 1;
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            prod *= nums[right];

            while(k <= prod && left<=right) {
                prod /= nums[left++];
            }

            count += right - left + 1;
        }
        return count;
    }
}