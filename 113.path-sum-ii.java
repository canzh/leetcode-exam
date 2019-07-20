/*
 * @lc app=leetcode id=113 lang=java
 *
 * [113] Path Sum II
 */
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {

        /// back-tracking solution

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currentResult = new ArrayList<>();

        pathSum(root, sum, currentResult, result);

        return result;
    }

    private void pathSum(TreeNode root, int sum, List<Integer> currentResult, List<List<Integer>> result) {
        if (root == null)
            return;

        currentResult.add(root.val);

        if (root.left == null && root.right == null && root.val == sum) {
            result.add(new ArrayList<>(currentResult));
        } else {
            pathSum(root.left, sum - root.val, currentResult, result);
            pathSum(root.right, sum - root.val, currentResult, result);
        }

        currentResult.remove(currentResult.size() - 1);
    }
}
