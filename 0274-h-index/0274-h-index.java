
class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int[] count = new int[n+1];

        for(int i=0; i < n; i++) {
            if(citations[i] > n) {
                count[n]++;
            } else {
                count[citations[i]]++;
            }
        }
        int total = 0;
        for (int i = n; i>=0; i--) {
            total+=count[i];
            if(total>=i) {
                return i;
            }
        }

        return 0;
    }
}