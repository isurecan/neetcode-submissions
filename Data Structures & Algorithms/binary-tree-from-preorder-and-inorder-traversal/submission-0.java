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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer,Integer> inorderIndexMap=new HashMap<>();
       //build a look up to find index of root to split trees into left and right halves
        for(int i=0; i<inorder.length; i++){
            inorderIndexMap.put(inorder[i],i);
        }

        return split(inorderIndexMap,preorder,
                    0, 0, inorder.length-1);
    }

    public TreeNode split(Map<Integer,Integer> inorderIndexMap,
                         int[] preorder, int rootIndex,
                         int left, int right){
        if (left > right)
        return null;

       //create root 
       TreeNode root=new TreeNode(preorder[rootIndex]);

        //split at root
        int mid=inorderIndexMap.get(preorder[rootIndex]);

        if(mid>left){
            root.left=split(inorderIndexMap,preorder,
                    rootIndex+1, left, mid-1);
        }

        if(mid<right){
            int leftSubtreeSize=mid-left;
            root.right=split(inorderIndexMap,preorder,
                    rootIndex+leftSubtreeSize+1, 
                    mid+1, right);
        }
        return root;
        }
}
