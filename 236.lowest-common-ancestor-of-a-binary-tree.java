import java.util.Set;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode id=236 lang=java
 *
 * [236] Lowest Common Ancestor of a Binary Tree
 *
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/description/
 *
 * algorithms
 * Medium (38.30%)
 * Likes:    2122
 * Dislikes: 141
 * Total Accepted:    299.8K
 * Total Submissions: 780K
 * Testcase Example:  '[3,5,1,6,2,0,8,null,null,7,4]\n5\n1'
 *
 * Given a binary tree, find the lowest common ancestor (LCA) of two given
 * nodes in the tree.
 * 
 * According to the definition of LCA on Wikipedia: “The lowest common ancestor
 * is defined between two nodes p and q as the lowest node in T that has both p
 * and q as descendants (where we allow a node to be a descendant of itself).”
 * 
 * Given the following binary tree:  root = [3,5,1,6,2,0,8,null,null,7,4]
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * Output: 3
 * Explanation: The LCA of nodes 5 and 1 is 3.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 * Output: 5
 * Explanation: The LCA of nodes 5 and 4 is 5, since a node can be a descendant
 * of itself according to the LCA definition.
 * 
 * 
 * 
 * 
 * Note:
 * 
 * 
 * All of the nodes' values will be unique.
 * p and q are different and both values will exist in the binary tree.
 * 
 * 
 */
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == root || q == root)
            return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null)
            return root;
        return left == null ? right : left;
    }

    // find path from root using Map with BFS
    public TreeNode lowestCommonAncestorWithMap(TreeNode root, TreeNode p, TreeNode q) {
        Queue<TreeNode> queue = new LinkedList<>();
        Map<TreeNode, TreeNode> parentMap = new HashMap<>();

        queue.add(root);
        parentMap.put(root, null);

        while (!parentMap.containsKey(p) || !parentMap.containsKey(q)) {
            TreeNode r = queue.poll();

            if (r.left != null) {
                queue.add(r.left);
                parentMap.put(r.left, r);
            }
            if (r.right != null) {
                queue.add(r.right);
                parentMap.put(r.right, r);
            }
        }

        Set<TreeNode> path = new HashSet<>();
        while (p != null) {
            path.add(p);
            p = parentMap.get(p);
        }

        while (!path.contains(q)) {
            q = parentMap.get(q);
        }
        return q;
    }

    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == root || q == root)
            return root;

        List<TreeNode> p1 = new LinkedList<>();
        List<TreeNode> p2 = new LinkedList<>();

        getPathFromRoot(root, p, p1);
        getPathFromRoot(root, q, p2);

        return findDiffPoint(p1, p2);
    }

    boolean getPathFromRoot(TreeNode root, TreeNode p, List<TreeNode> path) {
        if (root == null)
            return false;

        path.add(root);

        if (root == p)
            return true;

        if (getPathFromRoot(root.left, p, path))
            return true;
        if (getPathFromRoot(root.right, p, path))
            return true;

        path.remove(path.size() - 1);

        return false;
    }

    TreeNode findDiffPoint(List<TreeNode> l1, List<TreeNode> l2) {
        int len = Math.min(l1.size(), l2.size());
        TreeNode p = null;
        for (int i = 0; i < len; i++) {
            if (l1.get(i) == l2.get(i)) {
                p = l1.get(i);
            } else {
                break;
            }
        }
        return p;
    }
}
