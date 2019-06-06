/*
 * @lc app=leetcode id=94 lang=csharp
 *
 * [94] Binary Tree Inorder Traversal
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

    public IList<int> InorderTraversal(TreeNode root)
    {
        // Solution 1: recursive
        // List<int> result = new List<int>();
        // traversal(root, result);
        // return result;

        // Solution 2: iteration
        List<int> result = new List<int>();
        Stack<TreeNode> stack = new Stack<TreeNode>();

        var curr = root;

        while (curr != null || stack.Count > 0)
        {
            while (curr != null)
            {
                stack.Push(curr);
                curr = curr.left;
            }

            curr = stack.Pop();
            result.Add(curr.val);
            curr = curr.right;
        }

        return result;
    }

    void traversal(TreeNode root, List<int> list)
    {
        if (root == null) return;

        traversal(root.left, list);
        list.Add(root.val);
        traversal(root.right, list);
    }
}

