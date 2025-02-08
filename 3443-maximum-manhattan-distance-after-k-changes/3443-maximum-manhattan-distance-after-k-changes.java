class Solution {
    public int maxDistance(String s, int k) {
        int ans = 0;
        char[] hori = new char[]{'E','W'};
        char[] vert = new char[]{'N','S'};
        for(char hor: hori) {
            for(char ver: vert) {
                int remainingK = k, netx = 0, nety = 0;
                for(char ch: s.toCharArray()) {
                    if (hor == ch && remainingK > 0) {
                        ch = (ch == 'W') ? 'E' : 'W';
                        remainingK--;
                    } else if(ver == ch && remainingK > 0) {
                        ch = (ch=='N') ? 'S' : 'N';
                        remainingK--;
                    }
                    netx += (ch == 'E') ? 1 : 0;
                    netx -= (ch == 'W') ? 1 : 0;
                    nety += (ch == 'N') ? 1 : 0;
                    nety -= (ch == 'S') ? 1 : 0;
                    ans = Math.max(ans, Math.abs(netx) + Math.abs(nety));
                }
            }
        }
        return ans;

    }
}