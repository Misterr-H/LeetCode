class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int left = 0;
        int answer = 0;
        for (int right = 0; right < nums.length; right++) {
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);
            while (map.size() > k && left<=right) {
                map.put(nums[left], map.get(nums[left]) - 1);
                left ++;
            }
            if (map.size() == k) {
                answer += right - left;
            }
        }
        return answer;
    }
}