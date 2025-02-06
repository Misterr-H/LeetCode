class Info {
    int x;
    int y;
    int duration;
    public Info(int x, int y, int duration) {
        this.x = x;
        this.y = y;
        this.duration = duration;
    }
}

class Solution {
    public int orangesRotting(int[][] grid) {
        int ans = 0;
        int m = grid.length;
        int n = grid[0].length;

        Queue<Info> q = new LinkedList<>();
        int[][] visited = new int[m][n];

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 2) {
                    q.offer(new Info(i, j, 0));
                    visited[i][j] = 2;
                } else if(grid[i][j] == 1) {
                    visited[i][j] = 1;
                }
            }
        }

        int[] drow = {0, -1, 0, +1};
        int[] dcol = {-1, 0, 1, 0};

        while(!q.isEmpty()) {
            Info curr = q.poll();
            int r = curr.x;
            int c = curr.y;
            int t = curr.duration;
            ans = Math.max(ans, t);
            for(int i = 0; i<4; i++) {
                int nrow = r + drow[i];
                int ncol = c + dcol[i];

                if(nrow >= 0 && nrow < m && ncol >= 0 && ncol < n && grid[nrow][ncol] == 1 && visited[nrow][ncol] != 2) {
                    q.offer(new Info(nrow, ncol, t+1));
                    visited[nrow][ncol] = 2;
                }
            }

        }

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(visited[i][j] == 1) return -1;
            }
        }

        return ans;
    }
}