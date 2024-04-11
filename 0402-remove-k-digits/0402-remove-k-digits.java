class Solution {
    public String removeKdigits(String num, int k) {
        if (k == 0)
            return num;

        if(k==num.length())
            return "0";

        Stack<Character> st = new Stack<>();

        for(char c:num.toCharArray()) {
            if(!st.isEmpty() && k > 0 && st.peek() > c) {
                st.pop();
                k--;
            }
            st.push(c);
        }

        while(k>0) {
            st.pop();
            k--;
        }

        StringBuilder sb = new StringBuilder();

        while(!st.isEmpty()) {
            char c = st.pop();
            sb.append(c);
        }

        while(sb.length() > 0 && sb.charAt(sb.length() - 1) == '0') {
            sb.deleteCharAt(sb.length() - 1);
        }

        return sb.length() == 0 ? "0" :  sb.reverse().toString();
    }
}