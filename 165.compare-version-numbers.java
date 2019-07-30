/*
 * @lc app=leetcode id=165 lang=java
 *
 * [165] Compare Version Numbers
 *
 * https://leetcode.com/problems/compare-version-numbers/description/
 *
 * algorithms
 * Medium (23.50%)
 * Likes:    317
 * Dislikes: 1135
 * Total Accepted:    143K
 * Total Submissions: 593.5K
 * Testcase Example:  '"0.1"\n"1.1"'
 *
 * Compare two version numbers version1 and version2.
 * If version1 > version2 return 1; if version1 < version2 return -1;otherwise
 * return 0.
 * 
 * You may assume that the version strings are non-empty and contain only
 * digits and the . character.
 * The . character does not represent a decimal point and is used to separate
 * number sequences.
 * For instance, 2.5 is not "two and a half" or "half way to version three", it
 * is the fifth second-level revision of the second first-level revision.
 * You may assume the default revision number for each level of a version
 * number to be 0. For example, version number 3.4 has a revision number of 3
 * and 4 for its first and second level revision number. Its third and fourth
 * level revision number are both 0.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: version1 = "0.1", version2 = "1.1"
 * Output: -1
 * 
 * Example 2:
 * 
 * Input: version1 = "1.0.1", version2 = "1"
 * Output: 1
 * 
 * Example 3:
 * 
 * Input: version1 = "7.5.2.4", version2 = "7.5.3"
 * Output: -1
 * 
 * Example 4:
 * 
 * Input: version1 = "1.01", version2 = "1.001"
 * Output: 0
 * Explanation: Ignoring leading zeroes, both “01” and “001" represent the same
 * number “1”
 * 
 * Example 5:
 * 
 * Input: version1 = "1.0", version2 = "1.0.0"
 * Output: 0
 * Explanation: The first version number does not have a third level revision
 * number, which means its third level revision number is default to "0"
 * 
 * 
 * 
 * Note:
 * 
 * Version strings are composed of numeric strings separated by dots . and this
 * numeric strings may have leading zeroes. 
 * Version strings do not start or end with dots, and they will not be two
 * consecutive dots.
 * 
 */
class Solution {
    public int compareVersion(String version1, String version2) {
        String[] l1 = version1.split("\\.");
        String[] l2 = version2.split("\\.");

        int max = Math.max(l1.length, l2.length);

        for (int i = 0; i < max; i++) {
            Integer v1 = i < l1.length ? Integer.valueOf(l1[i]) : 0;
            Integer v2 = i < l2.length ? Integer.valueOf(l2[i]) : 0;

            int compare = v1.compareTo(v2);
            if (compare != 0)
                return compare;
        }

        return 0;
    }

    public int compareVersion2(String version1, String version2) {
        int[] v1 = Stream.of(version1.split("\\.")).mapToInt(Integer::parseInt).toArray();
        int[] v2 = Stream.of(version2.split("\\.")).mapToInt(Integer::parseInt).toArray();

        int l1 = v1.length;
        int l2 = v2.length;
        int min = Math.min(l1, l2);

        for (int i = 0; i < min; i++) {
            if (v1[i] < v2[i])
                return -1;
            if (v1[i] > v2[i])
                return 1;
        }

        int[] remain = l1 > l2 ? v1 : v2;

        for (int i = min; i < Math.max(l1, l2); i++) {
            if (remain[i] > 0) {
                return l1 > l2 ? 1 : -1;
            }
        }

        return 0;
    }
}
