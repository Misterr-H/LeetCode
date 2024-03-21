class Solution {
    public int leastInterval(char[] tasks, int n) {
        if (n==0)
            return tasks.length;
        int[] freq = new int[26];
        for(char c : tasks) {
            freq[c - 'A']++;
        }
        Arrays.sort(freq);
        int maxOccur = freq[25];
        int noOfMax = 0;
        for (int i:freq) {
            if (i == maxOccur) {
                noOfMax++;
            }
        }
        int answer = (maxOccur-1)*(n+1) + noOfMax;
        return Math.max(answer, tasks.length); // must put Math.max
    }
}