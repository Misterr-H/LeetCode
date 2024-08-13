class Solution {
    public int jump(int[] nums) {
        int near = 0;
        int far = 0;
        int jumps = 0;
        while(far < nums.length-1) {
            int farthest = 0;
            while(near <= far) {
                farthest = Math.max(near+nums[near], farthest);
                near++;
            }
            near = far+1;
            far = farthest;
            jumps++;
        }
        return jumps;
    }
}