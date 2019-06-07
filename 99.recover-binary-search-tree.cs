/*
 * @lc app=leetcode id=99 lang=csharp
 *
 * [99] Recover Binary Search Tree
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

    TreeNode first = null;
    TreeNode second = null;
    TreeNode pre = new TreeNode(int.MinValue);

    public void RecoverTree(TreeNode root)
    {
        traversal(root);

        var temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    void traversal(TreeNode root)
    {
        if (root == null) return;

        traversal(root.left);

        if (first == null && pre.val >= root.val)
        {
            first = pre;
        }

        if (first != null && pre.val >= root.val)
        {
            second = root;
        }

        pre = root;
        traversal(root.right);
    }
}

