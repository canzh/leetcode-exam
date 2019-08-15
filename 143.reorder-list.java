/*
 * @lc app=leetcode id=143 lang=java
 *
 * [143] Reorder List
 *
 * https://leetcode.com/problems/reorder-list/description/
 *
 * algorithms
 * Medium (31.79%)
 * Likes:    1019
 * Dislikes: 75
 * Total Accepted:    165.6K
 * Total Submissions: 520.9K
 * Testcase Example:  '[1,2,3,4]'
 *
 * Given a singly linked list L: L0→L1→…→Ln-1→Ln,
 * reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
 * 
 * You may not modify the values in the list's nodes, only nodes itself may be
 * changed.
 * 
 * Example 1:
 * 
 * 
 * Given 1->2->3->4, reorder it to 1->4->2->3.
 * 
 * Example 2:
 * 
 * 
 * Given 1->2->3->4->5, reorder it to 1->5->2->4->3.
 * 
 * 
 */
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null)
            return;

        // step 1: find middle
        ListNode p1 = head, p2 = head;

        while (p2.next != null && p2.next.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
        }

        // step 2: reverse second half
        ListNode p = p1.next;
        p2 = null;
        while (p != null) {
            ListNode temp = p.next;
            p.next = p2;
            p2 = p;
            p = temp;
        }

        // step 3: merge
        // p1 is middle, p2 is new head of second half
        p = head;
        while (p != p1) {
            ListNode temp = p2.next;
            p2.next = p.next;
            p.next = p2;
            p = p2.next;
            p2 = temp;
        }
    }

    // Memory Limit Exceeded
    public void reorderList1(ListNode head) {
        ListNode p = head;
        Stack<ListNode> stack = new Stack<>();

        while (p != null) {
            stack.push(p);
        }

        p = head;

        while (!stack.isEmpty()) {
            ListNode tmp = stack.pop();

            if (p == tmp) {
                p.next = null;
                break;
            }
            if (p.next == tmp) {
                p.next.next = null;
                break;
            }

            tmp.next = p.next;
            p.next = tmp;

            p = p.next;
        }

    }
}
