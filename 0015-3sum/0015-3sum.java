class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0; i < nums.length-2; i++) {
            if(nums[i] > 0)
                break;
            if(i>0) {
                if(nums[i] == nums[i-1])
                    continue;
            }
            int target = -nums[i];
            int left = i+1;
            int right = nums.length-1;
            while(left<right) {
                if(nums[left] + nums[right]==target && left!=right) {
                    List<Integer> ans1 = new ArrayList<>();
                    ans1.add(nums[i]);
                    ans1.add(nums[left]);
                    ans1.add(nums[right]);
                    ans.add(ans1);
                    while(left < right && nums[left] == nums[left+1]) left++;
                    while(left < right && nums[right] == nums[right-1]) right--;
                    left++;
                    right--;
                }
                else if (nums[left] + nums[right] > target) {
                    right--;
                } else {
                    left++;
                }
            }
            
        }
        return ans;
        
    }
}