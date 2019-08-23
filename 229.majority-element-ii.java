/*
 * @lc app=leetcode id=229 lang=java
 *
 * [229] Majority Element II
 *
 * https://leetcode.com/problems/majority-element-ii/description/
 *
 * algorithms
 * Medium (32.75%)
 * Likes:    971
 * Dislikes: 115
 * Total Accepted:    109K
 * Total Submissions: 332.1K
 * Testcase Example:  '[3,2,3]'
 *
 * Given an integer array of size n, find all elements that appear more than ⌊
 * n/3 ⌋ times.
 * 
 * Note: The algorithm should run in linear time and in O(1) space.
 * 
 * Example 1:
 * 
 * 
 * Input: [3,2,3]
 * Output: [3]
 * 
 * Example 2:
 * 
 * 
 * Input: [1,1,1,3,3,2,2,2]
 * Output: [1,2]
 * 
 */
class Solution {
    // First, we claim: given n numbers and the k counters, only less than n/(k+1)
    // times pair-out can happen.
    // That is to say:

    // given n numbers and 1 counter (which is the majority element problem), at
    // most (n/2) times pair-out can happen, which will lead to the survival of the
    // only element that appeared more than n/2 times.
    // given n numbers and 2 counters (which is our case), at most n/3 times of
    // pair-out can happen, which will lead to the survival of elements that
    // appeared more than n/3 times.
    // given n numbers and k counters, at most (n/k+1) times of pair-out can happen,
    // which will lead to the survival of elements that appeared more than n/(k+1)
    // times.
    // If this is the case, then n elements using two counters can at most pair out
    // less than (n/3) times, which will result in the survival of the elements that
    // appears more than (n/3) times.

    // Boyer-Moore Majority Vote algorithm
    // https://gregable.com/2013/10/majority-vote-algorithm-find-majority.html
    public List<Integer> majorityElement(int[] nums) {
        int candidate1 = 0, candidate2 = 1, num1 = 0, num2 = 0;
        for (int n : nums) {
            if (n == candidate1) {
                num1++;
            } else if (n == candidate2) {
                num2++;
            } else if (num1 == 0) {
                candidate1 = n;
                num1 = 1;
            } else if (num2 == 0) {
                candidate2 = n;
                num2 = 1;
            } else {
                num1--;
                num2--;
            }
        }

        num1 = 0;
        num2 = 0;

        for (int n : nums) {
            if (n == candidate1)
                num1++;
            else if (n == candidate2)
                num2++;
        }

        List<Integer> result = new LinkedList<>();

        if (num1 > nums.length / 3)
            result.add(candidate1);
        if (num2 > nums.length / 3)
            result.add(candidate2);

        return result;
    }
}
