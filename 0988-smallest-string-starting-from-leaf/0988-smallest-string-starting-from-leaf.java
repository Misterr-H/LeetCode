/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public String smallestFromLeaf(TreeNode root) {
        ArrayList<String> paths = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        dfs(root, sb, paths);
        Collections.sort(paths);
        return paths.get(0);
    }

    public void dfs(TreeNode root, StringBuilder sb, ArrayList<String> paths)   {
        if (root == null) {
            return;
        }
        sb.insert(0, (char)('a' + root.val));
        if(root.left == null && root.right == null) {
            
            paths.add(sb.toString());
        }
        dfs(root.left, sb, paths);
        dfs(root.right, sb, paths);
        sb.deleteCharAt(0);
    }
}