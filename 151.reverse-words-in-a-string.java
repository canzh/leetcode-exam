import java.util.List;

/*
 * @lc app=leetcode id=151 lang=java
 *
 * [151] Reverse Words in a String
 *
 * https://leetcode.com/problems/reverse-words-in-a-string/description/
 *
 * algorithms
 * Medium (16.69%)
 * Likes:    603
 * Dislikes: 2338
 * Total Accepted:    295.6K
 * Total Submissions: 1.7M
 * Testcase Example:  '"the sky is blue"'
 *
 * Given an input string, reverse the string word by word.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: "the sky is blue"
 * Output: "blue is sky the"
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: "  hello world!  "
 * Output: "world! hello"
 * Explanation: Your reversed string should not contain leading or trailing
 * spaces.
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: "a good   example"
 * Output: "example good a"
 * Explanation: You need to reduce multiple spaces between two words to a
 * single space in the reversed string.
 * 
 * 
 * 
 * 
 * Note:
 * 
 * 
 * A word is defined as a sequence of non-space characters.
 * Input string may contain leading or trailing spaces. However, your reversed
 * string should not contain leading or trailing spaces.
 * You need to reduce multiple spaces between two words to a single space in
 * the reversed string.
 * 
 * 
 * 
 * 
 * Follow up:
 * 
 * For C programmers, try to solve it in-place in O(1) extra space.
 */
class Solution {
    public String reverseWords(String s) {
        s = cleanSpace(s.toCharArray());
        char[] chars = s.toCharArray();

        // reverse whole string
        reverse(chars, 0, chars.length - 1);

        // reverse each word
        reverseWords(chars);

        return new String(chars);
    }

    void reverseWords(char[] chars) {
        int i = 0, j = 0, n = chars.length;
        while (j < n) {
            while (j < n && chars[j] == ' ') // skip space
                j++;

            i = j; // mark word start

            while (j < n && chars[j] != ' ')
                j++;
            reverse(chars, i, j - 1);
        }
    }

    String cleanSpace(char[] chars) {
        int i = 0, j = 0, n = chars.length;
        while (j < n) {
            while (j < n && chars[j] == ' ') // skip space
                j++;
            while (j < n && chars[j] != ' ') // copy words
                chars[i++] = chars[j++];
            while (j < n && chars[j] == ' ') // skip space
                j++;
            if (j < n)
                chars[i++] = ' ';
        }
        return new String(chars, 0, i);
    }

    void reverse(char[] chars, int low, int high) {
        while (low < high) {
            char tmp = chars[low];
            chars[low] = chars[high];
            chars[high] = tmp;
            low++;
            high--;
        }
    }

    public String reverseWords2(String s) {
        StringBuilder sb = new StringBuilder();
        List<String> words = new LinkedList<>();
        for (char c : s.toCharArray()) {
            if (c == ' ') {
                if (sb.length() > 0) {
                    words.add(0, sb.toString());
                    sb = new StringBuilder();
                }
                continue;
            }
            sb.append(c);
        }
        if (sb.length() > 0)
            words.add(0, sb.toString());

        sb = new StringBuilder();
        String sep = "";
        for (int i = 0; i < words.size(); i++) {
            sb.append(sep).append(words.get(i));
            sep = " ";
        }
        return sb.toString();
    }
}
