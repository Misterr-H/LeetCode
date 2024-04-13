class Solution {
    public int maximalRectangle(char[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return 0;

        int[] heights = new int[matrix[0].length];
        int maxArea = 0;

        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '1') {
                    heights[j]++;
                } else {
                    heights[j] = 0;
                }
            }
            maxArea = Math.max(maxArea, findMaxArea(heights));
        }

        return maxArea;
        
    }

    public int findMaxArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int index = 0;
        int maxArea = 0;

        while(index < heights.length) {
            if(stack.isEmpty() || heights[stack.peek()] <= heights[index]) {
                stack.push(index++);
            } else {
                int curr = stack.pop();
                int area = heights[curr] * (stack.isEmpty() ? index : index - stack.peek() - 1);
                maxArea = Math.max(area, maxArea);
            }
        }

        while(!stack.isEmpty()) {
            int curr = stack.pop();
                int area = heights[curr] * (stack.isEmpty() ? index : index - stack.peek() - 1);
                maxArea = Math.max(area, maxArea);
        }

        return maxArea;
    }
}