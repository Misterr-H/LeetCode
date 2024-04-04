class Solution {
    public int maxDepth(String s) {
        // Stack<Character> stack = new Stack<>();
        int maxDepth = 0;
        int currDepth = 0;

        for(int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                currDepth++;
                maxDepth = Math.max(currDepth, maxDepth);
            } else if(s.charAt(i) == ')') {
                currDepth--;
            }
        }

        if (currDepth == 0) {
            return maxDepth;
        }
        return -1;
    }
}