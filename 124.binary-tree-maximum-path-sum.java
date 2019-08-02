/*
 * @lc app=leetcode id=124 lang=java
 *
 * [124] Binary Tree Maximum Path Sum
 *
 * https://leetcode.com/problems/binary-tree-maximum-path-sum/description/
 *
 * algorithms
 * Hard (29.96%)
 * Likes:    1775
 * Dislikes: 134
 * Total Accepted:    207.3K
 * Total Submissions: 680.2K
 * Testcase Example:  '[1,2,3]'
 *
 * Given a non-empty binary tree, find the maximum path sum.
 * 
 * For this problem, a path is defined as any sequence of nodes from some
 * starting node to any node in the tree along the parent-child connections.
 * The path must contain at least one node and does not need to go through the
 * root.
 * 
 * Example 1:
 * 
 * 
 * Input: [1,2,3]
 * 
 * ⁠      1
 * ⁠     / \
 * ⁠    2   3
 * 
 * Output: 6
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: [-10,9,20,null,null,15,7]
 * 
 * -10
 * / \
 * 9  20
 * /  \
 * 15   7
 * 
 * Output: 42
 * 
 * 
 */
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxSumDownRootInclusive(root);
        return max;
    }

    int maxSumDownRootInclusive(TreeNode root) {
        if (root == null)
            return 0;

        int left = maxSumDownRootInclusive(root.left);
        int right = maxSumDownRootInclusive(root.right);
        left = Math.max(0, left);
        right = Math.max(0, right);

        max = Math.max(max, left + right + root.val);

        return Math.max(left, right) + root.val;
    }
}
