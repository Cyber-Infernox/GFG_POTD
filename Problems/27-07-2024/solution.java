class Solution {
    static int func(int index1, int index2, String str, String strReversed, int dp[][]) {
        if (index1 < 0 || index2 < 0)
            return 0;

        if (dp[index1][index2] != -1)
            return dp[index1][index2];

        if (str.charAt(index1) == strReversed.charAt(index2))
            return dp[index1][index2] = 1 + func(index1 - 1, index2 - 1, str, strReversed, dp);

        return dp[index1][index2] = 0 + Math.max(func(index1 - 1, index2, str, strReversed, dp),
                func(index1, index2 - 1, str, strReversed, dp));
    }

    static String reverse(String str) {
        String newStr = "";
        for (int i = 0; i < str.length(); i++) {
            newStr = str.charAt(i) + newStr;
        }
        return newStr;
    }

    static int countMin(String str) {
        // code here
        String reversedString = reverse(str);

        int len = str.length();

        int dp[][] = new int[len][len];
        for (int i = 0; i < len; i++) {
            Arrays.fill(dp[i], -1);
        }

        int LPS = func(len - 1, len - 1, str, reversedString, dp);

        return len - LPS;
    }
}