/*
 * @lc app=leetcode id=102 lang=csharp
 *
 * [102] Binary Tree Level Order Traversal
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
    public IList<IList<int>> LevelOrder(TreeNode root)
    {
        List<IList<int>> result = new List<IList<int>>();

        if (root == null) return result;

        Queue<TreeNode> queue = new Queue<TreeNode>();
        queue.Enqueue(root);

        while (queue.Count > 0)
        {
            var levelSize = queue.Count;

            var level = new List<int>(levelSize);

            for (int i = 0; i < levelSize; i++)
            {
                var peek = queue.Dequeue();
                if (peek.left != null) queue.Enqueue(peek.left);
                if (peek.right != null) queue.Enqueue(peek.right);

                level.Add(peek.val);
            }

            result.Add(level);
        }

        return result;
    }
}

