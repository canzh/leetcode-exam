/*
 * @lc app=leetcode id=222 lang=java
 *
 * [222] Count Complete Tree Nodes
 *
 * https://leetcode.com/problems/count-complete-tree-nodes/description/
 *
 * algorithms
 * Medium (33.39%)
 * Likes:    1056
 * Dislikes: 142
 * Total Accepted:    130.1K
 * Total Submissions: 371.4K
 * Testcase Example:  '[1,2,3,4,5,6]'
 *
 * Given a complete binary tree, count the number of nodes.
 * 
 * Note: 
 * 
 * Definition of a complete binary tree from Wikipedia:
 * In a complete binary tree every level, except possibly the last, is
 * completely filled, and all nodes in the last level are as far left as
 * possible. It can have between 1 and 2^h nodes inclusive at the last level
 * h.
 * 
 * Example:
 * 
 * 
 * Input: 
 * ⁠   1
 * ⁠  / \
 * ⁠ 2   3
 * ⁠/ \  /
 * 4  5 6
 * 
 * Output: 6
 * 
 */
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    // Explanation

    // The height of a tree can be found by just going left. Let a single node tree
    // have height 0. Find the height h of the whole tree. If the whole tree is
    // empty, i.e., has height -1, there are 0 nodes.

    // Otherwise check whether the height of the right subtree is just one less than
    // that of the whole tree, meaning left and right subtree have the same height.

    // If yes, then the last node on the last tree row is in the right subtree and
    // the left subtree is a full tree of height h-1. So we take the 2^h-1 nodes of
    // the left subtree plus the 1 root node plus recursively the number of nodes in
    // the right subtree.
    // If no, then the last node on the last tree row is in the left subtree and the
    // right subtree is a full tree of height h-2. So we take the 2^(h-1)-1 nodes of
    // the right subtree plus the 1 root node plus recursively the number of nodes
    // in the left subtree.
    // Since I halve the tree in every recursive step, I have O(log(n)) steps.
    // Finding a height costs O(log(n)). So overall O(log(n)^2).

    public int countNodes(TreeNode root) {
        int h = height(root);

        if (h < 0)
            return 0;

        int rightHeight = height(root.right);

        return (rightHeight == h - 1) ? (1 << h) + countNodes(root.right) : (1 << h - 1) + countNodes(root.left);
    }

    int height(TreeNode root) {
        return root == null ? -1 : 1 + height(root.left);
    }
}
