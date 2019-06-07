/*
 * @lc app=leetcode id=101 lang=csharp
 *
 * [101] Symmetric Tree
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
    public bool IsSymmetric(TreeNode root)
    {
        // Solution 1: recursive
        // return IsMirror(root, root);

        // Solution 2: iterative
        Queue<TreeNode> queue = new Queue<TreeNode>();
        queue.Enqueue(root);
        queue.Enqueue(root);

        while (queue.Count > 0)
        {
            var t1 = queue.Dequeue();
            var t2 = queue.Dequeue();

            if (t1 == null && t2 == null) continue;
            if (t1 == null || t2 == null) return false;
            if (t1.val != t2.val) return false;

            queue.Enqueue(t1.left);
            queue.Enqueue(t2.right);

            queue.Enqueue(t1.right);
            queue.Enqueue(t2.left);
        }

        return true;
    }

    public bool IsMirror(TreeNode root, TreeNode other)
    {
        if (root == null && other == null) return true;
        if (root == null || other == null) return false;

        if (root.val != other.val) return false;

        return IsMirror(root.left, other.right)
            && IsMirror(root.right, other.left);
    }
}

