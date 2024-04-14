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
    public int sumOfLeftLeaves(TreeNode root) {
        return recurSum(root.left, true) + recurSum(root.right, false);
        
    }

    public int recurSum(TreeNode root, boolean left) {
        if(root==null) {
            return 0;
        }
        if(left && root.left == null && root.right == null) {
            return root.val;
        } else if(!left && root.left == null && root.right == null) {
            return 0;
        }

        int leftNode = recurSum(root.left, true);
        int rightNode = recurSum(root.right, false);
        return leftNode + rightNode;
    }
}