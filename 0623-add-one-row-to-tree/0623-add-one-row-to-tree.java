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
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if(depth == 1) {
            TreeNode one = new TreeNode();
            one.val = val;
            one.left = root;
            return one;
        }
        Helper(root, val, depth, 1);
        return root;

    }

    public void Helper(TreeNode root, int val, int depth, int currDepth) {
        if(root == null) {
            return;
        }
        if(currDepth == depth-1) {
            TreeNode newLeft = new TreeNode();
            TreeNode newRight = new TreeNode();
            newLeft.val = val;
            newRight.val = val;
            TreeNode temp1 = root.left;
            TreeNode temp2  = root.right;
            root.left = newLeft;
            root.right = newRight;
            newLeft.left = temp1;
            newRight.right = temp2;
        }
        Helper(root.left, val, depth, currDepth+1);
        Helper(root.right, val, depth, currDepth+1);
    }
}