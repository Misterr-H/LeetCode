class Solution {
    private Set<String> dict;

    public List<String> wordBreak(String s, List<String> wordDict) {
        dict = new HashSet<>(wordDict);
        return wordBreakHelper(s);
    }

    private List<String> wordBreakHelper(String s) {
        List<String> result = new ArrayList<>();

        if(s.length() == 0){
            result.add("");
            return result;
        }

        for(int i = 1; i <= s.length(); i++) {
            String sub = s.substring(0, i);
            if(dict.contains(sub)) {
                List<String> rest = wordBreakHelper(s.substring(i));
                for(String rs: rest) {
                    result.add(sub + (rs.isEmpty() ? "" : (" " + rs)));
                }
            }
        }

        return result;
    }
}