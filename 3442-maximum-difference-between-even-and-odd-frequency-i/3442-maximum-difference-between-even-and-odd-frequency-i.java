class Solution {
    public int maxDifference(String s) {
        Map<Character, Integer> freq = new HashMap<>();

        for(int i = 0; i < s.length(); i++) {
            freq.put(s.charAt(i), freq.getOrDefault(s.charAt(i), 0) + 1);
        }
        int maxOdd = 0;
        int minEven = Integer.MAX_VALUE;

        for (int value : freq.values()) {
            if (value % 2 == 1) { // Odd frequency
                maxOdd = Math.max(value, maxOdd);
            } else { // Even frequency
                minEven = Math.min(value, minEven);
                // hasEven = true;
            }
        }

        return maxOdd-minEven;
    }
}