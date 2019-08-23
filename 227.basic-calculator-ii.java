import java.util.Deque;

/*
 * @lc app=leetcode id=227 lang=java
 *
 * [227] Basic Calculator II
 *
 * https://leetcode.com/problems/basic-calculator-ii/description/
 *
 * algorithms
 * Medium (34.14%)
 * Likes:    795
 * Dislikes: 131
 * Total Accepted:    121.9K
 * Total Submissions: 356.4K
 * Testcase Example:  '"3+2*2"'
 *
 * Implement a basic calculator to evaluate a simple expression string.
 * 
 * The expression string contains only non-negative integers, +, -, *, /
 * operators and empty spaces  . The integer division should truncate toward
 * zero.
 * 
 * Example 1:
 * 
 * 
 * Input: "3+2*2"
 * Output: 7
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: " 3/2 "
 * Output: 1
 * 
 * Example 3:
 * 
 * 
 * Input: " 3+5 / 2 "
 * Output: 5
 * 
 * 
 * Note:
 * 
 * 
 * You may assume that the given expression is always valid.
 * Do not use the eval built-in library function.
 * 
 * 
 */
class Solution {
    public int calculate(String s) {
        Deque<Integer> queue = new LinkedList<>();
        char sign = '+';
        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            }

            if ((!Character.isDigit(c) && c != ' ') || i == s.length() - 1) {
                if (sign == '+') {
                    queue.offer(num);
                } else if (sign == '-') {
                    queue.offer(-num);
                } else if (sign == '*') {
                    queue.offer(queue.pollLast() * num);
                } else if (sign == '/') {
                    queue.offer(queue.pollLast() / num);
                }

                sign = c;
                num = 0;
            }
        }

        int ret = 0;
        while (!queue.isEmpty())
            ret += queue.pollFirst();

        return ret;
    }

    public int calculate2(String s) {
        char[] chars = s.toCharArray();
        Deque<String> queue = new LinkedList<>();

        // Tokenize
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];

            if (!Character.isDigit(c)) {
                if (sb.length() > 0) {
                    queue.offerLast(sb.toString());
                    sb = new StringBuilder();
                }

                if (c == ' ')
                    continue;

                queue.offerLast(c + "");
                continue;
            }

            sb.append(c);
        }
        if (sb.length() > 0) {
            queue.offerLast(sb.toString());
        }

        // calc * and /
        String op1, op2, op;
        Deque<String> q = new LinkedList<>();
        while (!queue.isEmpty()) {
            op1 = queue.pollFirst();

            if (queue.isEmpty()) {
                q.offerLast(op1);
                break;
            }

            op = queue.pollFirst();

            if (op.equals("*") || op.equals("/")) {
                op2 = queue.pollFirst();
                int ret = 0;
                if (op.equals("*")) {
                    ret = Integer.parseInt(op1) * Integer.parseInt(op2);
                } else {
                    ret = Integer.parseInt(op1) / Integer.parseInt(op2);
                }
                // q.offerLast(String.valueOf(ret));
                queue.offerFirst(String.valueOf(ret));
            } else {
                q.offerLast(op1);
                q.offerLast(op);
            }
        }

        // calc + and -
        int result = Integer.parseInt(q.pollFirst());
        while (!q.isEmpty()) {
            op = q.pollFirst();

            if (op.equals("+")) {
                result += Integer.parseInt(q.pollFirst());
            } else {
                result -= Integer.parseInt(q.pollFirst());
            }
        }

        return result;
    }
}
