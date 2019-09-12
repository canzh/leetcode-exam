/*
 * @lc app=leetcode id=498 lang=java
 *
 * [498] Diagonal Traverse
 *
 * https://leetcode.com/problems/diagonal-traverse/description/
 *
 * algorithms
 * Medium (45.59%)
 * Likes:    402
 * Dislikes: 250
 * Total Accepted:    49.3K
 * Total Submissions: 107.7K
 * Testcase Example:  '[[1,2,3],[4,5,6],[7,8,9]]'
 *
 * Given a matrix of M x N elements (M rows, N columns), return all elements of
 * the matrix in diagonal order as shown in the below image.
 * 
 * 
 * 
 * Example:
 * 
 * 
 * Input:
 * [
 * ⁠[ 1, 2, 3 ],
 * ⁠[ 4, 5, 6 ],
 * ⁠[ 7, 8, 9 ]
 * ]
 * 
 * Output:  [1,2,4,7,5,3,6,8,9]
 * 
 * Explanation:
 * 
 * 
 * 
 * 
 * 
 * Note:
 * 
 * The total number of elements of the given matrix will not exceed 10,000.
 * 
 */
class Solution {
    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return new int[0];
        int m = matrix.length, n = matrix[0].length;
        int[] result = new int[m * n];
        int c = 0, r = 0;
        for (int i = 0; i < m * n; i++) {
            result[i] = matrix[r][c];
            if ((r + c) % 2 == 0) { // move up
                if (c == n - 1)
                    r++;
                else if (r == 0)
                    c++;
                else {
                    r--;
                    c++;
                }
            } else { // move down
                if (r == m - 1)
                    c++;
                else if (c == 0)
                    r++;
                else {
                    r++;
                    c--;
                }
            }
        }
        return result;
    }
}
