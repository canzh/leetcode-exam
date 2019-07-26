/*
 * @lc app=leetcode id=722 lang=java
 *
 * [722] Remove Comments
 *
 * https://leetcode.com/problems/remove-comments/description/
 *
 * algorithms
 * Medium (31.17%)
 * Likes:    168
 * Dislikes: 569
 * Total Accepted:    16.4K
 * Total Submissions: 52K
 * Note:
 * The length of source is in the range [1, 100].
 * The length of source[i] is in the range [0, 80].
 * Every open block comment is eventually closed.
 * There are no single-quote, double-quote, or control characters in the source
 * code.
 * 
 */
class Solution {
    public List<String> removeComments(String[] source) {
        List<String> result = new ArrayList<>();
        boolean inblock = false;
        StringBuilder sb = new StringBuilder();

        for (String line : source) {
            char[] chars = line.toCharArray();
            int i = 0;
            if (!inblock)
                sb = new StringBuilder();

            while (i < chars.length) {
                if (!inblock && i + 1 < chars.length && chars[i] == '/' && chars[i + 1] == '*') {
                    inblock = true;
                    i++;
                } else if (inblock && i + 1 < chars.length && chars[i] == '*' && chars[i + 1] == '/') {
                    inblock = false;
                    i++;
                } else if (!inblock && i + 1 < chars.length && chars[i] == '/' && chars[i + 1] == '/') {
                    break;
                } else if (!inblock) {
                    sb.append(chars[i]);
                }
                i++;
            }

            if (!inblock && sb.length() > 0) {
                result.add(sb.toString());
            }
        }

        return result;
    }
}
