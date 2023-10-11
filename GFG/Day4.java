//https://practice.geeksforgeeks.org/problems/check-for-balanced-tree/1
//Check for Balanced Tree
//11-10-2023

class Tree
{    
    //Function to check whether a binary tree is balanced or not.
    boolean isBalanced(Node root)
    {
	// Your code here
	    return height(root)!=-1;
    }
    int height(Node root){
        if(root==null){
            return 0;
        }
        int leftHeight=height(root.left);
        int rightHeight=height(root.right);
        if(Math.abs(rightHeight-leftHeight)>1 || Math.min(leftHeight,rightHeight)==-1){
            //if right subtree and left subtree have height diff greater then 1
            //or right subtree or left subtree already had a height diff greater then 1
            return -1;
        }
        return Math.max(leftHeight,rightHeight)+1;
    }
}