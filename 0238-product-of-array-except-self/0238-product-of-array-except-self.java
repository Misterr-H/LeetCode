class Solution {
    public int[] productExceptSelf(int[] nums) {
        int total = 1;
        int zeroCount = 0;
        int[] result = new int[nums.length];
        for(int i = 0; i < nums.length; i++) {
            total*=nums[i];
            if(nums[i] == 0) zeroCount++;
        }
        int totalWithoutZero = 1;
        if(zeroCount == 1) {
            for(int i = 0; i < nums.length; i++) {
                if(nums[i] != 0) totalWithoutZero*=nums[i];
            }
            for(int i = 0; i < nums.length; i++) {
                if(nums[i] != 0)
                    result[i] = 0;
                else result[i] = totalWithoutZero;
            }
        } else if (zeroCount > 1) {
            for(int i = 0; i< nums.length; i++) {
                result[i] = 0;
            }
        } else {
            for(int i = 0; i < nums.length; i++) {
                result[i] = total/nums[i];
            }
        }
        System.out.println(totalWithoutZero);
        return result;
    }
}