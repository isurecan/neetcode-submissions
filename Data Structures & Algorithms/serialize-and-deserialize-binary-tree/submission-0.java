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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb=new StringBuilder();
        preorder(root, sb);
        return sb.toString();
    }

    public void preorder(TreeNode root, StringBuilder sb){
        if(root==null){
            sb.append("N,");
            return;
        }

        sb.append(root.val).append(",");
        preorder(root.left, sb);
        preorder(root.right, sb);
    }


    int index=0;
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        index=0;
        String[] arr=data.split(",");
        return build(arr);
    }

    public TreeNode build(String[] arr){
       
        if(arr[index].equals("N")){
            index++;
            return null;
        }

//covert the string elemnt of array to integer for the value of root
        TreeNode root=new TreeNode(Integer.parseInt(arr[index++]));
        root.left=build(arr);
        root.right=build(arr);
        return root;
    }
}
