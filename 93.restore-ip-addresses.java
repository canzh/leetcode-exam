/*
 * @lc app=leetcode id=93 lang=java
 *
 * [93] Restore IP Addresses
 *
 * https://leetcode.com/problems/restore-ip-addresses/description/
 *
 * algorithms
 * Medium (32.13%)
 * Likes:    738
 * Dislikes: 307
 * Total Accepted:    148.5K
 * Total Submissions: 461.9K
 * Testcase Example:  '"25525511135"'
 *
 * Given a string containing only digits, restore it by returning all possible
 * valid IP address combinations.
 * 
 * Example:
 * 
 * 
 * Input: "25525511135"
 * Output: ["255.255.11.135", "255.255.111.35"]
 * 
 * 
 */
class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new LinkedList<>();
        backtrack(s, result, "", 0);
        return result;
    }

    private void backtrack(String s, List<String> result, String path, int k) {
        if (s.isEmpty() && k == 4) {
            result.add(path);
            return;
        }

        if (s.isEmpty() || k == 4) {
            return; // invalid
        }

        for (int i = 1; i <= (s.charAt(0) == '0' ? 1 : 3) && i <= s.length(); i++) {
            String str = s.substring(0, i);

            if (Integer.parseInt(str) < 256) {
                backtrack(s.substring(i), result, path == "" ? str : path + "." + str, k + 1);
            }
        }
    }
}
