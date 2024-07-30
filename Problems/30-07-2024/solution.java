// class Solution {

//     public static void DFS(int row, int col, int[][] m, int n, int[] delRow, int[] delCol, String s, ArrayList<String> ans, int visited[][]) {

//         if(row == (n - 1) && col == (n - 1)) {
//             ans.add(s);
//             return;
//         }

//         int newRow = row + delRow[0];
//         int newCol = col + delCol[0];
//         if(newRow >= 0 && newRow < n && newCol >= 0 && newCol < n && m[newRow][newCol] == 1 && visited[newRow][newCol] == 0) {
//             visited[newRow][newCol] = 1;
//             DFS(newRow, newCol, m, n, delRow, delCol, s + "D", ans, visited);
//             visited[newRow][newCol] = 0;
//         }

//         newRow = row + delRow[1];
//         newCol = col + delCol[1];
//         if(newRow >= 0 && newRow < n && newCol >= 0 && newCol < n && m[newRow][newCol] == 1 && visited[newRow][newCol] == 0) {
//             visited[newRow][newCol] = 1;
//             DFS(newRow, newCol, m, n, delRow, delCol, s + "R", ans, visited);
//             visited[newRow][newCol] = 0;
//         }

//         newRow = row + delRow[2];
//         newCol = col + delCol[2];
//         if(newRow >= 0 && newRow < n && newCol >= 0 && newCol < n && m[newRow][newCol] == 1 && visited[newRow][newCol] == 0) {
//             visited[newRow][newCol] = 1;
//             DFS(newRow, newCol, m, n, delRow, delCol, s + "U", ans, visited);
//             visited[newRow][newCol] = 0;
//         }

//         newRow = row + delRow[3];
//         newCol = col + delCol[3];
//         if(newRow >= 0 && newRow < n && newCol >= 0 && newCol < n && m[newRow][newCol] == 1 && visited[newRow][newCol] == 0) {
//             visited[newRow][newCol] = 1;
//             DFS(newRow, newCol, m, n, delRow, delCol, s + "L", ans, visited);
//             visited[newRow][newCol] = 0;
//         }

//     }

//     public static ArrayList<String> findPath(int[][] m, int n) {
//         // Your code here
//         int delRow[] = {1, 0, -1, 0};
//         int delCol[] = {0, 1, 0, -1};

//         int visited[][] = new int[n][n];

//         ArrayList<String> ans = new ArrayList<>();

//         if(m[0][0] == 0)
//         return ans;

//         visited[0][0] = 1;
//         DFS(0, 0, m, n, delRow, delCol, "", ans, visited);

//         return ans;

//     }
// }

class Solution {
    public ArrayList<String> findPath(int[][] mat) {
        ArrayList<String> res = new ArrayList<>();
        recurse(mat, 0, 0, "", res);
        return res;
    }

    static void recurse(int[][] mat, int r, int c, String res, ArrayList<String> ans) {
        if (r == mat.length - 1 && c == mat[0].length - 1 && mat[r][c] == 1) {
            ans.add(res);
            return;
        }
        if (r < 0 || r >= mat.length || c < 0 || c >= mat[0].length)
            return;
        if (mat[r][c] == 0 || mat[r][c] == -1)
            return;
        mat[r][c] = -1;

        recurse(mat, r - 1, c, res + "U", ans);
        recurse(mat, r + 1, c, res + "D", ans);
        recurse(mat, r, c - 1, res + "L", ans);
        recurse(mat, r, c + 1, res + "R", ans);
        mat[r][c] = 1;

    }
}