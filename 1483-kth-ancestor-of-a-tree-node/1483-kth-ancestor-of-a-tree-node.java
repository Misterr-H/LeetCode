class TreeAncestor {
    static int Max = 16;
    int[] parent;
    int n;
    static int[][] up;

    public void build(int[] parent) {
        int N = parent.length;
        up = new int[Max][N];
        for(int i=0; i<N; i++) {
            up[0][i] = parent[i];
        }

        for(int i=1; i<Max; i++) {
            for(int j=0; j<N; j++) {
                if(up[i-1][j] == -1) {
                    up[i][j] = -1;
                } else {
                    up[i][j] = up[i-1][up[i-1][j]];
                }
            }
        }
    }


    public TreeAncestor(int n, int[] parent) {
        
        build(parent);
    }
    
    public int getKthAncestor(int node, int k) {
        for(int i=0; i<Max; i++) {
            int mask = 1<<i;
            if((mask&k) > 0) {
                if(node == -1) {
                    node = -1;
                } else node = up[i][node];
            }
        }
        return node;
    }
}

/**
 * Your TreeAncestor object will be instantiated and called as such:
 * TreeAncestor obj = new TreeAncestor(n, parent);
 * int param_1 = obj.getKthAncestor(node,k);
 */