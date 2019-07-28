/*
 * @lc app=leetcode id=273 lang=java
 *
 * [273] Integer to English Words
 *
 * https://leetcode.com/problems/integer-to-english-words/description/
 *
 * algorithms
 * Hard (24.56%)
 * Likes:    569
 * Dislikes: 1590
 * Total Accepted:    109.5K
 * Total Submissions: 444.9K
 * Testcase Example:  '123'
 *
 * Convert a non-negative integer to its english words representation. Given
 * input is guaranteed to be less than 2^31 - 1.
 * 
 * Example 1:
 * 
 * 
 * Input: 123
 * Output: "One Hundred Twenty Three"
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: 12345
 * Output: "Twelve Thousand Three Hundred Forty Five"
 * 
 * Example 3:
 * 
 * 
 * Input: 1234567
 * Output: "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty
 * Seven"
 * 
 * 
 * Example 4:
 * 
 * 
 * Input: 1234567891
 * Output: "One Billion Two Hundred Thirty Four Million Five Hundred Sixty
 * Seven Thousand Eight Hundred Ninety One"
 * 
 * 
 */
class Solution {
    static String[] suffix = { "", " Thousand", " Million", " Billion" };
    static String[] hundredPlaceArray = { "", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty",
            "Ninety" };
    static String[] unitPlaceArray = { "", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine" };
    static Map<Integer, String> tensPlaceMap = new HashMap<>();

    {
        tensPlaceMap.put(10, "Ten");
        tensPlaceMap.put(11, "Eleven");
        tensPlaceMap.put(12, "Twelve");
        tensPlaceMap.put(13, "Thirteen");
        tensPlaceMap.put(14, "Fourteen");
        tensPlaceMap.put(15, "Fifteen");
        tensPlaceMap.put(16, "Sixteen");
        tensPlaceMap.put(17, "Seventeen");
        tensPlaceMap.put(18, "Eighteen");
        tensPlaceMap.put(19, "Nineteen");
    }

    public String numberToWords(int num) {
        if (num == 0)
            return "Zero";

        int groupIndex = 0;
        StringBuilder sb;
        List<String> strs = new ArrayList<>();

        while (num != 0) {
            sb = new StringBuilder();
            int rem = num % 1000;

            int hundred = rem / 100;
            int tens = rem % 100;

            if (hundred != 0) {
                sb.append(unitPlaceArray[hundred]).append(" Hundred ");
            }

            if (tensPlaceMap.containsKey(tens)) {
                sb.append(tensPlaceMap.get(tens));
            } else {
                int ten = tens / 10;
                int single = tens % 10;
                if (ten > 1)
                    sb.append(hundredPlaceArray[ten]).append(" ").append(unitPlaceArray[single]);
            }

            sb.append(suffix[groupIndex]);

            strs.add(0, sb.toString());

            groupIndex++;
            num /= 1000;
        }

        return String.join(" ", strs);
    }
}
