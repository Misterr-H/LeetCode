class Solution {
    public int findDuplicate(int[] nums) {
        Arrays.sort(nums);
        int p = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i]!=p)
                p = nums[i];
                else
                return p;
        }
        return p;
    }
}