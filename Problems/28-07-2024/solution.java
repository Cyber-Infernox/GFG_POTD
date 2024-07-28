class Solution {
    String removeDups(String str) {
        // code here
        HashSet<Character> set = new HashSet<>();
        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            if (!set.contains(str.charAt(i))) {
                ans.append(str.charAt(i));
                set.add(str.charAt(i));
            }
        }

        return ans.toString();
    }
}