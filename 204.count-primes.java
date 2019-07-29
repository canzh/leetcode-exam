/*
 * @lc app=leetcode id=204 lang=java
 *
 * [204] Count Primes
 *
 * https://leetcode.com/problems/count-primes/description/
 *
 * algorithms
 * Easy (29.40%)
 * Likes:    1160
 * Dislikes: 426
 * Total Accepted:    253.1K
 * Total Submissions: 859K
 * Testcase Example:  '10'
 *
 * Count the number of prime numbers less than a non-negative number, n.
 * 
 * Example:
 * 
 * 
 * Input: 10
 * Output: 4
 * Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.
 * 
 * 
 */
class Solution {
    public int countPrimes(int n) {
        boolean[] notPrime = new boolean[n];

        int ans = 0;
        for (int i = 2; i < n; i++) {
            if (!notPrime[i])
                ans++;
            for (int j = 2; i * j < n; j++) {
                notPrime[i * j] = true;
            }
        }

        return ans;
    }

    public int countPrimes_timeexceed(int n) {
        if (n < 3)
            return 0;
        int ans = 1;
        for (int i = 3; i < n; i = i + 2) {
            boolean isPrime = true;
            for (int j = 2; j <= Math.sqrt(i); j++) {
                if (i % j == 0)
                    isPrime = false;
            }
            if (isPrime)
                ans++;
        }
        return ans;
    }
}
