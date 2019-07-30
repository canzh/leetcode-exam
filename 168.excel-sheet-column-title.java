/*
 * @lc app=leetcode id=168 lang=java
 *
 * [168] Excel Sheet Column Title
 *
 * https://leetcode.com/problems/excel-sheet-column-title/description/
 *
 * algorithms
 * Easy (28.95%)
 * Likes:    770
 * Dislikes: 149
 * Total Accepted:    178.5K
 * Total Submissions: 610K
 * Testcase Example:  '1'
 *
 * Given a positive integer, return its corresponding column title as appear in
 * an Excel sheet.
 * 
 * For example:
 * 
 * 
 * ⁠   1 -> A
 * ⁠   2 -> B
 * ⁠   3 -> C
 * ⁠   ...
 * ⁠   26 -> Z
 * ⁠   27 -> AA
 * ⁠   28 -> AB 
 * ⁠   ...
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: 1
 * Output: "A"
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: 28
 * Output: "AB"
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: 701
 * Output: "ZY"
 * 
 */
class Solution {
    public String convertToTitle(int n) {
        String ret = "";
        while (n != 0) {
            char c = (char) ((n - 1) % 26 + 'A');
            ret = c + ret;
            n = (n - 1) / 26;
        }
        return ret;
    }

    String convertToTitle2(int n) {
        return n == 0 ? "" : convertToTitle(--n / 26) + (n % 26 + 'A');
    }
}
