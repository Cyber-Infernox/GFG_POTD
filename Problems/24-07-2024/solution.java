class Solution {
    // Function to check whether a Binary Tree is BST or not.
    boolean isBST(Node root) {
        // code here.
        return isbst(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    
    boolean isbst(Node root, int min, int max) {
        if(root == null)
        return true;
        
        if(root.data < min || root.data > max)
        return false;
        
        return isbst(root.left, min, root.data - 1) && isbst(root.right, root.data + 1, max);
    }
}