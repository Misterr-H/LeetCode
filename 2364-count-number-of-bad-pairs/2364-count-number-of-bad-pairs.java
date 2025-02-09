class Solution {
    public long countBadPairs(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        long n = nums.length;
        long totalPairs = n * (n - 1) / 2;
        long goodPairs = 0;

        for (int i = 0; i < nums.length; i++) {
            int key = nums[i] - i;  // Key remains the same as your code
            goodPairs += map.getOrDefault(key, 0);  // Add existing good pairs
            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        return totalPairs - goodPairs;
    }
}