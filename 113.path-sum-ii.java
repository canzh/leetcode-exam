/*
 * @lc app=leetcode id=113 lang=java
 *
 * [113] Path Sum II
 *
 * https://leetcode.com/problems/path-sum-ii/description/
 *
 * algorithms
 * Medium (40.56%)
 * Likes:    966
 * Dislikes: 35
 * Total Accepted:    243.2K
 * Total Submissions: 587.5K
 * Testcase Example:  '[5,4,8,11,null,13,4,7,2,null,null,5,1]\n22'
 *
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's
 * sum equals the given sum.
 * 
 * Note: A leaf is a node with no children.
 * 
 * Example:
 * 
 * Given the below binary tree and sum = 22,
 * 
 * 
 * ⁠     5
 * ⁠    / \
 * ⁠   4   8
 * ⁠  /   / \
 * ⁠ 11  13  4
 * ⁠/  \    / \
 * 7    2  5   1
 * 
 * 
 * Return:
 * 
 * 
 * [
 * ⁠  [5,4,11,2],
 * ⁠  [5,8,4,5]
 * ]
 * 
 * 
 */
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        helper(root, sum, current, result);

        return result;
    }

    private void helper(TreeNode root, int sum, List<Integer> current, List<List<Integer>> result) {
        if (root == null)
            return;

        current.add(root.val);

        if (root.left == null && root.right == null && root.val == sum) {
            result.add(new ArrayList<Integer>(current));
        } else {
            helper(root.left, sum - root.val, current, result);
            helper(root.right, sum - root.val, current, result);
        }

        current.remove(current.size() - 1);
    }
}
