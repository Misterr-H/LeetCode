class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(dfs(board, word, 0, i, j)) return true;
            }
        }

        return false;
    }

    public boolean dfs(char[][] board, String word, int index, int i, int j) {
        if (index == word.length())
            return true;
        
        if (i>=board.length || i < 0 || j < 0 || j >= board[0].length || board[i][j] != word.charAt(index))
            return false;
        
        board[i][j] = '#';

        boolean exist = dfs(board, word, index+1, i+1, j) ||
                        dfs(board, word, index+1, i, j+1) ||
                        dfs(board, word, index+1, i-1, j) ||
                        dfs(board, word, index+1, i, j-1);

        board[i][j] = word.charAt(index);

        return exist;
    }
}