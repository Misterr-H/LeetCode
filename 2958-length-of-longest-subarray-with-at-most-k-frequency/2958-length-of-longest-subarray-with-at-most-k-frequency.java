class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int answer = 0;
        HashMap<Integer, Integer> freq = new HashMap<>();
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            freq.put(nums[right], freq.getOrDefault(nums[right], 0) + 1);
            if (freq.get(nums[right]) <= k)
                answer = Math.max(answer, right - left + 1);
            while(freq.get(nums[right]) > k && left <= right) {
                freq.put(nums[left], freq.get(nums[left]) - 1);
                left++;
            }
        }
        return answer;
        
    }
}