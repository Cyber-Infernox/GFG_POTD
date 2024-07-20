class Solution {
    // Return the root of the modified tree after removing all the half nodes.
    public Node RemoveHalfNodes(Node root) {
        // Code Here
        if (root == null)
            return root;

        root.left = RemoveHalfNodes(root.left);
        root.right = RemoveHalfNodes(root.right);

        if (root.left == null && root.right == null)
            return root;

        if (root.left == null) {
            return root.right;
        } else if (root.right == null)
            return root.left;

        return root;
    }
}