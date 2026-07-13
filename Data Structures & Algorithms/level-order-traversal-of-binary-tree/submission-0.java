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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>>res=new ArrayList<>();

        if(root==null)
        return res;

        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty()){
            int levelsize=q.size();
            List<Integer> levelElem=new ArrayList<>();

            for(int i=0; i<levelsize; i++){
                TreeNode temp=q.poll();
                levelElem.add(temp.val);

                if(temp.left!=null)
                q.offer(temp.left);

                if(temp.right!=null)
                q.offer(temp.right);
            }
            res.add(levelElem);
        }
        return res;
    }
}
