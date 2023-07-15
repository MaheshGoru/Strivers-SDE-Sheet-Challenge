/*https://www.codingninjas.com/studio/problems/preorder-traversal_3838888?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website*/
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
	// TC O(n) | SC O(h)
    public static List < Integer > getPreOrderTraversal(TreeNode root) {
    	// Write your code here.
		List<Integer> list = new ArrayList<>();
		preOrderTraversal(root, list);
		return list;
    }
	private static void preOrderTraversal(TreeNode root, List<Integer> list){
		if(root == null) return;
		list.add(root.data);
		preOrderTraversal(root.left, list);
		preOrderTraversal(root.right, list);
	}
}
