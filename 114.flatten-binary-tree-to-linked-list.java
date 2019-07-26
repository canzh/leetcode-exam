/*
 * @lc app=leetcode id=114 lang=java
 *
 * [114] Flatten Binary Tree to Linked List
 *
 * https://leetcode.com/problems/flatten-binary-tree-to-linked-list/description/
 *
 * algorithms
 * Medium (42.29%)
 * Likes:    1597
 * Dislikes: 208
 * Total Accepted:    249.2K
 * Total Submissions: 576.7K
 * Testcase Example:  '[1,2,5,3,4,null,6]'
 *
 * Given a binary tree, flatten it to a linked list in-place.
 * 
 * For example, given the following tree:
 * 
 * 
 * ⁠   1
 * ⁠  / \
 * ⁠ 2   5
 * ⁠/ \   \
 * 3   4   6
 * 
 * 
 * The flattened tree should look like:
 * 
 * 
 * 1
 * ⁠\
 * ⁠ 2
 * ⁠  \
 * ⁠   3
 * ⁠    \
 * ⁠     4
 * ⁠      \
 * ⁠       5
 * ⁠        \
 * ⁠         6
 * 
 * 
 */
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {

    // Comment: refer to morris traversal

    public void flatten(TreeNode root) {
        flatten(root, null);
    }

    TreeNode flatten(TreeNode root, TreeNode pre) {
        // use post order but right -> left -> root
        if (root == null)
            return pre;

        pre = flatten(root.right, pre);
        pre = flatten(root.left, pre);

        root.right = pre;
        root.left = null;

        return root;
    }
}
