class Info {
    int x;
    int y;

    public Info(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<Info> q = new LinkedList<>();
        boolean rotten = false;
        boolean fresh = false;
        for(int i = 0; i < grid.length; i++) {
            for( int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 2) {
                    q.add(new Info(i,j));
                    rotten = true;
                }
                if(grid[i][j] == 1){
                    fresh = true;
                }
            }
        }
        if(fresh == false) {
            return 0;
        }
        if(rotten == false) {
            return -1;
        }
        int min = 0;
        while(!q.isEmpty()) {
            int n = q.size();
            while(n>0) {
                Info info = q.poll();
                int r = info.x;
                int c = info.y;
                if(r+1<grid.length && grid[r+1][c]==1){
                    q.add(new Info(r+1,c));
                    grid[r+1][c] = 2;
                }
                if(r-1 >= 0 && grid[r-1][c] == 1) {
                    q.add(new Info(r-1, c));
                    grid[r-1][c] = 2;
                }
                if(c+1 < grid[0].length && grid[r][c+1] == 1) {
                    q.add(new Info(r, c+1));
                    grid[r][c+1] = 2;
                }
                if(c-1 >= 0 && grid[r][c-1] == 1) {
                    q.add(new Info(r, c-1));
                    grid[r][c-1] = 2;
                }
                n--;
            }
            min++;
        }
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }
        return min - 1;
    }
}