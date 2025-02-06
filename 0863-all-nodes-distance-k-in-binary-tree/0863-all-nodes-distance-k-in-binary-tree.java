/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    Map<TreeNode, TreeNode> rel;

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Queue<TreeNode> q = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();

        rel = new HashMap<>();

        buildParentMap(root, null);
        q.offer(target);
        visited.add(target);
        List<Integer> result = new ArrayList<>();

        int distance = 0;
        while(!q.isEmpty() && distance <= k) {
            int size = q.size();

            for(int i = 0; i<size; i++) {
                TreeNode curr = q.poll();

                if(distance == k) {
                    result.add(curr.val);
                    continue;
                }

                if(curr.left!=null && !visited.contains(curr.left)) {
                    q.offer(curr.left);
                    visited.add(curr.left);
                }

                if(curr.right!=null && !visited.contains(curr.right)) {
                    q.offer(curr.right);
                    visited.add(curr.right);
                }

                TreeNode parent = rel.get(curr);
                if(parent!=null && !visited.contains(parent)) {
                    q.offer(parent);
                    visited.add(parent);
                }

            }
            distance++;
            
        }

        return result;
    }

    private void buildParentMap(TreeNode child, TreeNode parent) {
        if(child == null) return;
        rel.put(child, parent);
        buildParentMap(child.left, child);
        buildParentMap(child.right, child);
    }
}