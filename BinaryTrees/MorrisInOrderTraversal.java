/*https://www.codingninjas.com/studio/problems/inorder-traversal_3839605?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website&leftPanelTab=1*/
import java.util.* ;
import java.io.*; 
/*
    
    Following is the Binary Tree node structure:

    public class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.data = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
           this.data = val;
            this.left = left;
            this.right = right;
        }
    }

*/

public class Solution {
	// Threaded Binary Tree Approach | TC O(2n) | SC O(1)
    public static List < Integer > getInOrderTraversal(TreeNode root) {
    	// Write your code here.
        List<Integer> list = new ArrayList<>();
        while(root != null){
            TreeNode leftNode = root.left;
            if(leftNode == null){
                list.add(root.data);
                root = root.right;
            }else{
                while(leftNode.right != null){
                    if(leftNode.right == root)
                        break;
                    leftNode = leftNode.right;
                }
                if(leftNode.right == root){
                    leftNode.right = null;
                    list.add(root.data);   
                    root = root.right;
                }else{
                    leftNode.right = root;           
                    root = root.left;
                }
            }
        }
        return list;
    }


    
}
