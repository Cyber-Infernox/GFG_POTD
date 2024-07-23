/*
class Node  
{ 
    int data; 
    Node left, right; 
   
    public Node(int d)  
    { 
        data = d; 
        left = right = null; 
    } 
}
*/

class Solution {
    // Function to return a list of integers denoting the node
    // values of both the BST in a sorted order.
    public void inOrder(Node root, ArrayList<Integer> arr) {
        if (root == null)
            return;

        inOrder(root.left, arr);
        arr.add(root.data);
        inOrder(root.right, arr);
    }

    public List<Integer> mergeArray(ArrayList<Integer> arr1, ArrayList<Integer> arr2) {
        int len1 = arr1.size();
        int len2 = arr2.size();
        ArrayList<Integer> arr = new ArrayList<>();

        int i = 0;
        int j = 0;

        while (i < len1 && j < len2) {
            if (arr1.get(i) <= arr2.get(j)) {
                arr.add(arr1.get(i));
                i++;
            } else if (arr1.get(i) > arr2.get(j)) {
                arr.add(arr2.get(j));
                j++;
            }
        }

        while (i < len1) {
            arr.add(arr1.get(i));
            i++;
        }

        while (j < len2) {
            arr.add(arr2.get(j));
            j++;
        }

        return arr;
    }

    public List<Integer> merge(Node root1, Node root2) {
        // Write your code here
        ArrayList<Integer> arr1 = new ArrayList<>();
        ArrayList<Integer> arr2 = new ArrayList<>();

        inOrder(root1, arr1);
        inOrder(root2, arr2);

        return mergeArray(arr1, arr2);
    }
}