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

    //leftlongest path + rightlongest path + 1
    int diameter=0;

    public int diameterOfBinaryTree(TreeNode root) { 
       longestPath(root);
       return diameter;
    }

    public int longestPath(TreeNode root){
        if(root==null){
            return 0;
        }
        int llp=longestPath(root.left);
        int rlp=longestPath(root.right);
        diameter=Math.max(diameter,llp + rlp);
        return Math.max(llp,rlp)+1;
    }
}
