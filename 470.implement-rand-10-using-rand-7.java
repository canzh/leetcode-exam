/*
 * @lc app=leetcode id=470 lang=java
 *
 * [470] Implement Rand10() Using Rand7()
 *
 * https://leetcode.com/problems/implement-rand10-using-rand7/description/
 *
 * algorithms
 * Medium (45.17%)
 * Likes:    234
 * Dislikes: 84
 * Total Accepted:    11.7K
 * Total Submissions: 25.9K
 * Testcase Example:  '1'
 *
 * Given a function rand7 which generates a uniform random integer in the range
 * 1 to 7, write a function rand10 which generates a uniform random integer in
 * the range 1 to 10.
 * 
 * Do NOT use system's Math.random().
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: 1
 * Output: [7]
 * 
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: 2
 * Output: [8,4]
 * 
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: 3
 * Output: [8,1,10]
 * 
 * 
 * 
 * 
 * Note:
 * 
 * 
 * rand7 is predefined.
 * Each testcase has one argument: n, the number of times that rand10 is
 * called.
 * 
 * 
 * 
 * 
 * Follow up:
 * 
 * 
 * What is the expected value for the number of calls to rand7() function?
 * Could you minimize the number of calls to rand7()?
 * 
 * 
 * 
 * 
 * 
 */
/**
 * The rand7() API is already defined in the parent class SolBase. public int
 * rand7();
 * 
 * @return a random integer in the range 1 to 7
 */
class Solution extends SolBase {
    // Generalization
    // Implement randM() using randN() when M > N:
    // Step 1: Use randN() to generate randX(), where X >= M. In this problem, I use
    // 7 * (rand7() - 1) + (rand7() - 1) to generate rand49() - 1.
    // Step 2: Use randX() to generate randM(). In this problem, I use rand49() to
    // generate rand40() then generate rand10.

    // Note: N^b * (randN() - 1) + N^(b - 1) * (randN() - 1) + N^(b - 2) * (randN()
    // - 1) + ... + N^0 * (randN() - 1) generates randX() - 1, where X = N^(b + 1).
    public int rand10() {
        int result = 40;
        while (result >= 40) {
            result = 7 * (rand7() - 1) + (rand7() - 1);
        }
        return result % 10 + 1;
    }
}
