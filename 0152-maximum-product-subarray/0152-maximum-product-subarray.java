class Solution {
    public int maxProduct(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;

        int minProduct = nums[0];
        int maxProduct = nums[0];
        int answer = maxProduct;
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] == 0) {
                minProduct = 1;
                maxProduct = 1;
                answer = Math.max(answer, 0); 
                continue;
            }
            int temp = minProduct;
            minProduct = Math.min(Math.min(nums[i] * minProduct, nums[i]), nums[i] * maxProduct);
            maxProduct = Math.max(Math.max(nums[i] * temp, nums[i]), nums[i] * maxProduct);

            answer = Math.max(answer, maxProduct);
        }

        return answer;
    }
}