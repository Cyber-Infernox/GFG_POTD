class Solution {
    public String printString(String s, char ch, int count) {
        // code here
        int i = 0;
        for (i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ch) {
                count--;
            }

            if (count == 0)
                break;
        }

        if (i < (s.length() - 1))
            return s.substring(i + 1);
        else
            return "";
    }
}