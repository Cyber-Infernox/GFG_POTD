// class Node  
// { 
//     int data; 
//     Node left, right; 

//     public Node(int d)  
//     { 
//         data = d; 
//         left = right = null; 
//     } 
// }

class Solution {
    // Return the size of the largest sub-tree which is also a BST
    static int largestBst(Node root) {
        // Write your code here
        if (isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE)) {
            return countNodes(root);
        }

        int left = largestBst(root.left);
        int right = largestBst(root.right);

        return Math.max(left, right);
    }

    static boolean isBST(Node root, int min, int max) {
        if (root == null)
            return true;

        if (root.data < min || root.data > max)
            return false;

        return isBST(root.left, min, root.data - 1) && isBST(root.right, root.data + 1, max);
    }

    static int countNodes(Node root) {
        if (root == null)
            return 0;

        return 1 + countNodes(root.left) + countNodes(root.right);
    }
}