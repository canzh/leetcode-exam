import java.util.Deque;
import java.util.Stack;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode id=654 lang=java
 *
 * [654] Maximum Binary Tree
 *
 * https://leetcode.com/problems/maximum-binary-tree/description/
 *
 * algorithms
 * Medium (76.59%)
 * Likes:    1151
 * Dislikes: 144
 * Total Accepted:    90.1K
 * Total Submissions: 117.6K
 * Testcase Example:  '[3,2,1,6,0,5]'
 *
 * 
 * Given an integer array with no duplicates. A maximum tree building on this
 * array is defined as follow:
 * 
 * The root is the maximum number in the array. 
 * The left subtree is the maximum tree constructed from left part subarray
 * divided by the maximum number.
 * The right subtree is the maximum tree constructed from right part subarray
 * divided by the maximum number. 
 * 
 * 
 * 
 * 
 * Construct the maximum tree by the given array and output the root node of
 * this tree.
 * 
 * 
 * Example 1:
 * 
 * Input: [3,2,1,6,0,5]
 * Output: return the tree root node representing the following tree:
 * 
 * ⁠     6
 * ⁠   /   \
 * ⁠  3     5
 * ⁠   \    / 
 * ⁠    2  0   
 * ⁠      \
 * ⁠       1
 * 
 * 
 * 
 * Note:
 * 
 * The size of the given array will be in the range [1,1000].
 * 
 * 
 */
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums == null || nums.length == 0)
            return null;

        // return helper(nums, 0, nums.length - 1);

        // O(n) = n solution

        Deque<TreeNode> queue = new LinkedList<>();

        for (int i = 0; i < nums.length; i++) {
            TreeNode cur = new TreeNode(nums[i]);

            while (!queue.isEmpty() && queue.peekLast().val < nums[i]) {
                cur.left = queue.pollLast();
            }

            if (!queue.isEmpty()) {
                queue.peekLast().right = cur;
            }

            queue.offerLast(cur);
        }

        return queue.peekFirst();
    }

    // O(n) = n^2
    TreeNode helper(int[] nums, int start, int end) {
        if (start > end)
            return null;

        int maxIndex = findMaxIndex(nums, start, end);

        TreeNode root = new TreeNode(nums[maxIndex]);
        root.left = helper(nums, start, maxIndex - 1);
        root.right = helper(nums, maxIndex + 1, end);

        return root;
    }

    private int findMaxIndex(int[] nums, int start, int end) {
        int maxIndex = start;
        for (int i = start + 1; i <= end; i++) {
            if (nums[i] > nums[maxIndex]) {
                maxIndex = i;
            }
        }

        return maxIndex;
    }
}
