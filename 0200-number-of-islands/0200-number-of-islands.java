class Solution {
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[n-1].length;
        int visited[][] = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                visited[i][j] = 0;
            }
        }
        int count = 0;
        Queue<Pair<Integer, Integer>> q = new LinkedList<>();
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(visited[i][j] == 0 && grid[i][j] == '1') {
                    count++;
                    bfs(i, j, q, grid, visited);
                }
            }
        }
        return count;
    }

    public void bfs(int i, int j, Queue<Pair<Integer, Integer>> q, char[][] grid, int[][] visited) {
        visited[i][j] = 1;
        q.add(new Pair<Integer, Integer>(i, j));
        int n = grid.length;
        int m = grid[0].length;

        while(!q.isEmpty()) {
            Pair<Integer, Integer> p = q.poll();
            int ro = p.getKey();
            int col = p.getValue();
            for(int delro = -1; delro <= 1; delro++) {
                for(int delcol = -1; delcol <= 1; delcol++) {
                    if ((delro == 0 && delcol != 0) || (delro != 0 && delcol == 0)) {
                        int newro = ro + delro;
                        int newcol = col + delcol;
                        if(newro >= 0 && newro < n && newcol >= 0 && newcol < m && grid[newro][newcol] == '1' && visited[newro][newcol] == 0) {
                            q.add(new Pair(newro, newcol));
                            visited[newro][newcol] = 1;
                        }
                    }
                }
            }
        }
    }
}