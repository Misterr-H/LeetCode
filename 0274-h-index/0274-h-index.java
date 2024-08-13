
class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int n = citations.length;
        int h = 0;
        for(int i = 0; i < n; i++) {
            if(n-i>=citations[i]) {
                h = citations[i];
            }
        }
        return h;
    }
}