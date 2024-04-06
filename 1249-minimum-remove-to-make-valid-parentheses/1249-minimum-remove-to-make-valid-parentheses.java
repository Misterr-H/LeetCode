class Solution {
    public String minRemoveToMakeValid(String s) {
        StringBuilder sb = new StringBuilder();
        int count = 0;

        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(') {
                count++;
                sb.append(s.charAt(i));
            } else if(s.charAt(i) == ')') {
                if(count > 0) {
                    count--;
                    sb.append(s.charAt(i));
                }
            } else {
                sb.append(s.charAt(i));
            }
        }
        String result = sb.toString();
        
        sb.setLength(0);

        count = 0;

        for(int i = result.length() - 1; i >= 0; i--) {
            if(result.charAt(i) == ')') {
                count++;
                sb.append(result.charAt(i));
            } else if(result.charAt(i) == '(') {
                if(count > 0) {
                    count--;
                    sb.append(result.charAt(i));
                }
            } else {
                sb.append(result.charAt(i));
            }
        }
        sb.reverse();

        return sb.toString();
    }
}