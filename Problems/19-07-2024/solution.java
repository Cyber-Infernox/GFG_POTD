class Solution {
    int binarySearch(ArrayList<Integer> list, int value) {
        int low = 0;
        int high = list.size() - 1;
        
        while(low <= high) {
            int mid = (low + high) / 2;
            
            if(list.get(mid) == value)
            return mid;
            
            else if(list.get(mid) > value)
            high = mid - 1;
            
            else
            low = mid + 1;
        }
        
        return -1;
    }
    
    int[] constructLowerArray(int[] arr) {
        // code here
        ArrayList<Integer> list = new ArrayList<>();
        
        for(int i = 0; i < arr.length; i++) {
            list.add(arr[i]);
        }
        
        Collections.sort(list);
        
        for(int i = 0; i < arr.length; i++) {
            int value = binarySearch(list, arr[i]);
            
            while (value > 0 && list.get(value - 1).equals(list.get(value))) {
                value--;
            }
            
            arr[i] = value;
            
            list.remove(value);
        }
        
        return arr;
    }
}