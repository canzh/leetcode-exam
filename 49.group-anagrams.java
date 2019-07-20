/*
 * @lc app=leetcode id=49 lang=java
 *
 * [49] Group Anagrams
 *
 * https://leetcode.com/problems/group-anagrams/description/
 *
 * algorithms
 * Medium (46.62%)
 * Likes:    1720
 * Dislikes: 115
 * Total Accepted:    349.6K
 * Total Submissions: 738.1K
 * Testcase Example:  '["eat","tea","tan","ate","nat","bat"]'
 *
 * Given an array of strings, group anagrams together.
 * 
 * Example:
 * 
 * 
 * Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * Output:
 * [
 * ⁠ ["ate","eat","tea"],
 * ⁠ ["nat","tan"],
 * ⁠ ["bat"]
 * ]
 * 
 * Note:
 * 
 * 
 * All inputs will be in lowercase.
 * The order of your output does not matter.
 * 
 * 
 */
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        int[] buffer = new int[26];

        for (String str : strs) {
            // Solution 1
            // String code = encodeString(str);

            // Solution 2
            String code = encodeStringByCharCount(str, buffer);

            if (!map.containsKey(code)) {
                map.put(code, new ArrayList<String>());
            }

            map.get(code).add(str);
        }

        return new ArrayList(map.values());
    }

    private String encodeStringBySort(String str) {
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        return new String(chars).intern();
    }

    private String encodeStringByCharCount(String str, int[] buffer) {
        Arrays.fill(buffer, 0);

        for (char c : str.toCharArray()) {
            buffer[c - 'a']++;
        }

        StringBuffer sb = new StringBuffer(str.length());
        for(int count : buffer) {
            sb.append("#");
            sb.append(count);
        }

        return sb.toString();
    }
}
