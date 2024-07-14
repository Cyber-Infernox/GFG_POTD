class Solution {
    void segregate0and1(int[] arr) {
        // code here
        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                arr[count] = 0;
                count++;
            }
        }

        while (count != arr.length) {
            arr[count] = 1;
            count++;
        }
    }
}