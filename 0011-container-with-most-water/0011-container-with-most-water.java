class Solution {
    public int maxArea(int[] height) {
        int big = 0;
        int index = 0;
        int ans = 0;
        for(int i=0; i<height.length; i++) {
            if(height[i] > big) {
                big = height[i];
                index = i;
            }
                if(height[i]*(i-index)>ans)
                    ans = height[i]*(i-index);
            
        }
        return ans;
    }
}