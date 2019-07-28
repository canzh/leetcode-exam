/*
 * @lc app=leetcode id=258 lang=java
 *
 * [258] Add Digits
 *
 * https://leetcode.com/problems/add-digits/description/
 *
 * algorithms
 * Easy (54.42%)
 * Likes:    484
 * Dislikes: 815
 * Total Accepted:    245.2K
 * Total Submissions: 450.3K
 * Testcase Example:  '38'
 *
 * Given a non-negative integer num, repeatedly add all its digits until the
 * result has only one digit.
 * 
 * Example:
 * 
 * 
 * Input: 38
 * Output: 2 
 * Explanation: The process is like: 3 + 8 = 11, 1 + 1 = 2. 
 * Since 2 has only one digit, return it.
 * 
 * 
 * Follow up:
 * Could you do it without any loop/recursion in O(1) runtime?
 */
class Solution {
    // digit root problem
    // https://en.wikipedia.org/wiki/Digital_root#Congruence_formula
    public int addDigits(int num) {
        return 1 + (num - 1) % 9;
    }
}
