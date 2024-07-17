class Solution {
    // Function to construct binary tree from parent array.
    public Node createTree(int parent[]) {
        // Your code here
        int n = parent.length;

        Node treeNodes[] = new Node[n];

        for (int i = 0; i < n; i++) {
            treeNodes[i] = new Node(i);
        }

        Node root = null;

        for (int i = 0; i < n; i++) {
            if (parent[i] == -1) {
                root = treeNodes[i];
            } else {
                Node pNode = treeNodes[parent[i]];

                if (pNode.left == null) {
                    pNode.left = treeNodes[i];
                } else {
                    pNode.right = treeNodes[i];
                }
            }
        }

        return root;
    }
}