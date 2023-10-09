// https://practice.geeksforgeeks.org/problems/height-of-binary-tree/1
//Height of Binary Tree
//9-10-2023

class Solution {
    //Function to find the height of a binary tree.
    int height(Node node) 
    {
        // code here 
        if(node==null){
            return 0;
        }
        //get the height of left child
        int leftHeight=height(node.left);
        //get the height of right child
        int rightHeight=height(node.right);
        //return the maximum of left and right height and add 1 for the parent node
        return Math.max(leftHeight,rightHeight)+1;
    }
}