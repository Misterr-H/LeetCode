class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        if(source == destination) return true;
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for(int[] edge : edges) {
            int u = edge[0]; int v = edge[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n];
        q.add(source);
        while(!q.isEmpty()) {
            int curr = q.poll();
            if(curr == destination) return true;
            visited[curr] = true;
            for(int neighbour:graph.get(curr)) {
                if(!visited[neighbour]) {
                    q.add(neighbour);
                }
            }
        }
        return false;
    }
}