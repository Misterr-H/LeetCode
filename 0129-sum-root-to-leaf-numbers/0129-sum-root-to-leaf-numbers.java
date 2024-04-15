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
    public int sumNumbers(TreeNode root) {
        if(root == null)
            return 0;
        if (root.left == null && root.right == null) {
            return root.val;
        }
        return helper(root.left, root.val) + helper(root.right, root.val);
        
    }

    public int helper(TreeNode root, int tillNow) {
        if(root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return tillNow*10 + root.val;
        }
        return helper(root.left, tillNow*10 + root.val) + helper(root.right, tillNow*10 + root.val);
    }
}