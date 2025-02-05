class Solution {
    public int minimumOperations(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = nums.length;

        int ans = 0;

        for(int i = 0; i < n; i++) {
            if(!map.containsKey(nums[i]) && nums[i]!=0) {
            map.put(nums[i], 1);
            ans++;
            }

        }
        return ans;
    }
}