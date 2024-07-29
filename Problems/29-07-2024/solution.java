class Solution {
    public int rowWithMax1s(int arr[][]) {
        // code here
        int max = Integer.MIN_VALUE;
        int index = -1;
        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr[i].length; j++) {
                if(arr[i][j] == 1) {
                    if(arr[i].length - j > max) {
                        max = arr[i].length - j;
                        index = i;
                    }
                    break;
                }
            }
        }
        
        return index;
    }
}