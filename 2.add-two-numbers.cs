/*
 * @lc app=leetcode id=2 lang=csharp
 *
 * [2] Add Two Numbers
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     public int val;
 *     public ListNode next;
 *     public ListNode(int x) { val = x; }
 * }
 */
using System.Numerics;
using System.Text;

public class Solution
{
    /*
        Big number case which can't be store in numberic types
     */

    public ListNode AddTwoNumbers(ListNode l1, ListNode l2)
    {
        // StringBuilder sb1 = new StringBuilder();

        // while (l1 != null)
        // {
        //     sb1.Insert(0, l1.val);
        //     l1 = l1.next;
        // }

        // StringBuilder sb2 = new StringBuilder();

        // while (l2 != null)
        // {
        //     sb1.Insert(0, l2.val);
        //     l2 = l2.next;
        // }

        // var number1 = BigInteger.Parse(sb1.ToString());
        // var number2 = BigInteger.Parse(sb2.ToString());

        // var sum = BigInteger.Add(number1, number2);
        // var sumString = sum.ToString();

        var list1 = l1;
        var list2 = l2;
        bool carry = false;

        ListNode result = new ListNode(0);
        ListNode tail = result;

        while (list1 != null || list2 != null)
        {
            int a = list1 == null ? 0 : list1.val;
            int b = list2 == null ? 0 : list2.val;

            int sum = a + b + (carry ? 1 : 0);
            if (sum > 9) carry = true;
            else carry = false;

            tail.next = new ListNode(sum % 10);
            tail = tail.next;

            list1 = list1?.next;
            list2 = list2?.next;
        }

        if (carry)
        {
            tail.next = new ListNode(1);
        }

        return result.next;
    }
}

