class Solution {
    public long countSubarrays(int[] nums, int k) {
        int maxElement = 0;
        for(int i = 0; i < nums.length; i++) {
            maxElement = Math.max(maxElement, nums[i]);
        }

        int left = 0;
        int count = 0;
        long answer = 0;
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == maxElement) {
                count++;
            }
            while (count>=k && left <= right) {
                answer += nums.length - right;
                if (nums[left] == maxElement) {
                    count--;
                }
                left++;
            }
        }
        return answer;
    }
}