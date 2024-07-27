class Solution {
    boolean kPangram(String str, int k) {
        // Create a HashSet to store unique alphabetic characters
        HashSet<Character> set = new HashSet<>();

        int alphabeticCount = 0;

        // Add each alphabetic character in the string to the set
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (Character.isLetter(ch)) {
                set.add(ch);
                alphabeticCount++;
            }
        }

        // Check if the number of alphabetic characters is less than 26
        if (alphabeticCount < 26) {
            return false;
        }

        // If the set size is 26, it's already a pangram
        if (set.size() == 26) {
            return true;
        }

        // Check if we can make it a pangram by replacing up to k characters
        int rem = 26 - set.size();
        if (rem <= k) {
            return true;
        }

        // Otherwise, it's not possible
        return false;
    }
}
