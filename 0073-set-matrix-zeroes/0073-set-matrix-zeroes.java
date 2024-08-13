class Solution {
    public void setZeroes(int[][] matrix) {
        boolean fr = false;
        boolean fc = false;

        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] == 0) {
                    if (i == 0) fr = true;
                    if (j == 0) fc = true;
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for(int i=1; i< matrix.length; i++) {
            if(matrix[i][0] == 0) {
                for(int j= 1; j < matrix[i].length; j++) {
                    matrix[i][j] = 0;
                }
            }
        }

        for(int j = 0; j < matrix[0].length; j++) {
            if(matrix[0][j] == 0) {
                for(int i = 1; i < matrix.length; i++) {
                    matrix[i][j] = 0;
                }
            }
        }

        if(fr == true) {
            for(int i = 0; i < matrix[0].length; i++) {
                matrix[0][i] = 0;
            }
        }

        if(fc == true) {
            for(int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}