class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) {
            return Collections.singletonList(0);
        }

        List<Set<Integer>> adjacencyLists = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            adjacencyLists.add(new HashSet<>());
        }

        int[] degrees = new int[n];
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adjacencyLists.get(u).add(v);
            adjacencyLists.get(v).add(u);
            degrees[u]++;
            degrees[v]++;
        }

        Queue<Integer> leaves = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (degrees[i] == 1) {
                leaves.offer(i);
            }
        }

        List<Integer> result = new ArrayList<>();
        while (n > 2) {
            int leavesSize = leaves.size();
            n -= leavesSize;
            for (int i = 0; i < leavesSize; i++) {
                int leaf = leaves.poll();
                for (int neighbor : adjacencyLists.get(leaf)) {
                    degrees[neighbor]--;
                    if (degrees[neighbor] == 1) {
                        leaves.offer(neighbor);
                    }
                }
            }
        }

        while (!leaves.isEmpty()) {
            result.add(leaves.poll());
        }

        return result;
    }
}