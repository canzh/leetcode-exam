/*
 * @lc app=leetcode id=86 lang=java
 *
 * [86] Partition List
 *
 * https://leetcode.com/problems/partition-list/description/
 *
 * algorithms
 * Medium (38.03%)
 * Likes:    759
 * Dislikes: 204
 * Total Accepted:    173.6K
 * Total Submissions: 456.1K
 * Testcase Example:  '[1,4,3,2,5,2]\n3'
 *
 * Given a linked list and a value x, partition it such that all nodes less
 * than x come before nodes greater than or equal to x.
 * 
 * You should preserve the original relative order of the nodes in each of the
 * two partitions.
 * 
 * Example:
 * 
 * 
 * Input: head = 1->4->3->2->5->2, x = 3
 * Output: 1->2->2->4->3->5
 * 
 * 
 */
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
class Solution {
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null)
            return head;

        ListNode dummySmall = new ListNode(0);
        ListNode dummyBig = new ListNode(0);
        ListNode small = dummySmall, big = dummyBig;
        ListNode p = head;

        while (p != null) {
            if (p.val < x) {
                small.next = p;
                small = small.next;
            } else {
                big.next = p;
                big = big.next;
            }
            p = p.next;
        }

        big.next = null;
        small.next = dummyBig.next;

        return dummySmall.next;
    }
}
