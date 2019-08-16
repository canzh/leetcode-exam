/*
 * @lc app=leetcode id=92 lang=java
 *
 * [92] Reverse Linked List II
 *
 * https://leetcode.com/problems/reverse-linked-list-ii/description/
 *
 * algorithms
 * Medium (35.68%)
 * Likes:    1375
 * Dislikes: 97
 * Total Accepted:    208K
 * Total Submissions: 582.5K
 * Testcase Example:  '[1,2,3,4,5]\n2\n4'
 *
 * Reverse a linked list from position m to n. Do it in one-pass.
 * 
 * Note: 1 ≤ m ≤ n ≤ length of list.
 * 
 * Example:
 * 
 * 
 * Input: 1->2->3->4->5->NULL, m = 2, n = 4
 * Output: 1->4->3->2->5->NULL
 * 
 * 
 */
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || head.next == null)
            return head;

        int len = 0;
        // ListNode dummy = new ListNode(0);
        ListNode p = head, prev = null, start = null;// prev = dummy, start = dummy;
        // dummy.next = head;

        while (p != null) {
            if (len == n) {
                break;
            }
            if (len >= m) {
                ListNode tmp = p.next;
                p.next = prev;
                prev = p;
                p = tmp;
            } else {
                start = prev;
                prev = p;
                p = p.next;
            }
            len++;
        }

        if (start == null) {
            head.next = p;
            return prev;
        }

        start.next.next = p;
        start.next = prev;
        return head;
    }
}
