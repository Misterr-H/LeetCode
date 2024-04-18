class Solution {
    public int islandPerimeter(int[][] grid) {
        int perimeter = 0;

        for(int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1)
                    perimeter += calPeri(grid, i, j);
            }
        }
        return perimeter;
    }

    public int calPeri(int[][] grid, int i, int j) {
        int perimeter = 0;

        if (j == 0 || grid[i][j-1] == 0) {
            perimeter++;
        }

        if(j == grid[i].length - 1 || grid[i][j+1] == 0) {
            perimeter++;
        }

        if(i == 0 || grid[i-1][j] == 0) {
            perimeter++;
        }

        if(i == grid.length - 1 || grid[i+1][j] == 0) {
            perimeter++;
        }

        return perimeter;
    }
}