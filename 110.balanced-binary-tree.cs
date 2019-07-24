/*
 * @lc app=leetcode id=110 lang=csharp
 *
 * [110] Balanced Binary Tree
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
public class Solution {
    public bool IsBalanced (TreeNode root) {
        return dfsHeight (root) != -1;
    }

    private int dfsHeight (TreeNode root) {
        if (root == null) return 0;

        var leftHeight = dfsHeight (root.left);
        if (leftHeight == -1) return -1;

        var rightHeight = dfsHeight (root.right);
        if (rightHeight == -1) return -1;

        if (Math.Abs (leftHeight - rightHeight) > 1) return -1;

        return Math.Max (leftHeight, rightHeight) + 1;
    }
}