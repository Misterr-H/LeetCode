class Solution {
    public int[] productExceptSelf(int[] nums) {
       int[] result = new int[nums.length];
       Arrays.fill(result, 1);
       int prefixProduct = 1;

       for(int i = 0; i < nums.length; i++) {
        result[i] *= prefixProduct;
        prefixProduct *= nums[i];
       }
       int p = 1;

       for(int i = nums.length - 1; i >= 0; i--) {
        result[i] *= p;
        p *= nums[i];
       }

       return result;
    }
}