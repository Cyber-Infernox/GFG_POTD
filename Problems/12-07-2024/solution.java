class Solution {
    Boolean isLeaf(Node root) {
        if(root.left == null && root.right == null)
        return true;
        return false;
    }
    
    void func(Node root, int target) {
        if(root == null) {
            return;
        }
        
        target -= root.data;
        
        if(target == 0 && isLeaf(root)) {
            ans = true;
            return;
        }
        
        func(root.left, target);
        func(root.right, target);
        
        target += root.data;
    }
    
    Boolean ans = false;
    
    /*you are required to complete this function */
    boolean hasPathSum(Node root, int target) {
        // Your code here
        func(root, target);
        
        return ans;
    }
}