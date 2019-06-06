/*
 * @lc app=leetcode id=98 lang=csharp
 *
 * [98] Validate Binary Search Tree
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left;
 *     public TreeNode right;
 *     public TreeNode(int x) { val = x; }
 * }
 */
public class Solution
{
    public bool IsValidBST(TreeNode root)
    {
        // Solution 1: Inorder traversal

        Stack<TreeNode> stack = new Stack<TreeNode>();

        var curr = root;
        double inorder = double.MinValue; // for test case of int.MinValue

        while (curr != null || stack.Count > 0)
        {
            while (curr != null)
            {
                stack.Push(curr);
                curr = curr.left;
            }

            curr = stack.Pop();

            if (inorder >= curr.val) return false;
            inorder = curr.val;

            curr = curr.right;
        }

        return true;
    }
}

