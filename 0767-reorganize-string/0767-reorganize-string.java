class Solution {
    public String reorganizeString(String s) {
        int[] freq = new int[26];
        for(char c: s.toCharArray()) {
            freq[c - 'a']++;
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> b[1] - a[1]);
        // for(char c: s.toCharArray()) {
        //     pq.offer(new int[]{c-'a', freq[c-'a']});
        // }

        for(int i = 0; i < 26; i++) {
            if(freq[i] > 0) pq.offer(new int[] {i, freq[i]});
        }

        if(pq.peek()[1] > (s.length() + 1)/2) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        while(pq.size() >= 2) {
            int[] el1 = pq.poll();
            int[] el2 = pq.poll();

            sb.append((char)(el1[0] + 'a'));
            sb.append((char)(el2[0] + 'a'));

            el1[1]--;
            el2[1]--;
            if(el1[1] > 0) pq.offer(el1);
            if(el2[1] > 0) pq.offer(el2);
        }

        if(!pq.isEmpty()) {
            int[] el1 = pq.poll();

            sb.append((char)(el1[0] + 'a'));
        }

        return sb.toString();
    }
}