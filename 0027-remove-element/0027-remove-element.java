class Solution {
    public int removeElement(int[] nums, int val) {
        if(nums.length == 0)
            return 0;

        int i = 0; 
        int k = nums.length - 1;

        while( i < k) {
            if (nums[k] == val)
                k--;
            if(nums[i]!=val){
                i++;
            } else {
                nums[i] = nums[k];
                nums[k] = val;
                i++;
                k--;
            }
        }

        for(int j = 0; j < nums.length; j++) {
            if(nums[j] == val)
                return j;
        }
    
        return i+1;
    }
}