import java.util.Collections;
import java.util.List;

/*
 * @lc app=leetcode id=17 lang=java
 *
 * [17] Letter Combinations of a Phone Number
 *
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/
 *
 * algorithms
 * Medium (41.49%)
 * Likes:    2282
 * Dislikes: 307
 * Total Accepted:    405.8K
 * Total Submissions: 966K
 * Testcase Example:  '"23"'
 *
 * Given a string containing digits from 2-9 inclusive, return all possible
 * letter combinations that the number could represent.
 * 
 * A mapping of digit to letters (just like on the telephone buttons) is given
 * below. Note that 1 does not map to any letters.
 * 
 * 
 * 
 * Example:
 * 
 * 
 * Input: "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * 
 * 
 * Note:
 * 
 * Although the above answer is in lexicographical order, your answer could be
 * in any order you want.
 * 
 */
class Solution {
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.isEmpty())
            return new ArrayList<>();

        Map<String, String> maps = new HashMap<>();
        maps.put("2", "abc");
        maps.put("3", "def");
        maps.put("4", "ghi");
        maps.put("5", "jkl");
        maps.put("6", "mno");
        maps.put("7", "pqrs");
        maps.put("8", "tuv");
        maps.put("9", "wxyz");
        List<String> result = new ArrayList<>();
        List<String> current = new ArrayList<>();

        helper(digits, 0, maps, result, current);

        return result;
    }

    private void helper(String digits, int index, Map<String, String> maps, List<String> result, List<String> current) {
        if (digits.length() == index) {
            result.add(String.join("", current));
            return;
        }

        char[] chars = maps.get(String.valueOf(digits.charAt(index))).toCharArray();
        for (char c : chars) {
            current.add(String.valueOf(c));
            helper(digits, index + 1, maps, result, current);
            current.remove(current.size() - 1);
        }
    }
}
