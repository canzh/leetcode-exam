import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/*
 * @lc app=leetcode id=373 lang=java
 *
 * [373] Find K Pairs with Smallest Sums
 *
 * https://leetcode.com/problems/find-k-pairs-with-smallest-sums/description/
 *
 * algorithms
 * Medium (34.46%)
 * Likes:    810
 * Dislikes: 69
 * Total Accepted:    74.8K
 * Total Submissions: 216.7K
 * Testcase Example:  '[1,7,11]\n[2,4,6]\n3'
 *
 * You are given two integer arrays nums1 and nums2 sorted in ascending order
 * and an integer k.
 * 
 * Define a pair (u,v) which consists of one element from the first array and
 * one element from the second array.
 * 
 * Find the k pairs (u1,v1),(u2,v2) ...(uk,vk) with the smallest sums.
 * 
 * Example 1:
 * 
 * 
 * Input: nums1 = [1,7,11], nums2 = [2,4,6], k = 3
 * Output: [[1,2],[1,4],[1,6]] 
 * Explanation: The first 3 pairs are returned from the sequence: 
 * [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]
 * 
 * Example 2:
 * 
 * 
 * Input: nums1 = [1,1,2], nums2 = [1,2,3], k = 2
 * Output: [1,1],[1,1]
 * Explanation: The first 2 pairs are returned from the sequence: 
 * [1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]
 * 
 * Example 3:
 * 
 * 
 * Input: nums1 = [1,2], nums2 = [3], k = 3
 * Output: [1,3],[2,3]
 * Explanation: All possible pairs are returned from the sequence: [1,3],[2,3]
 * 
 * 
 */
class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        int m = nums1.length, n = nums2.length;
        List<List<Integer>> result = new ArrayList<>();
        if (m == 0 || n == 0 || k == 0)
            return result;

        PriorityQueue<Data> queue = new PriorityQueue<>((a, b) -> a.v1 + a.v2 - b.v1 - b.v2);
        for (int i = 0; i < Math.min(m, k); i++) {
            queue.offer(new Data(0, nums1[i], nums2[0]));
        }

        // It is actually the same as how we merge k sorted list
        // Remember how we do in "merge k sorted list"? We simply add the head of the
        // list into the heap and when a node is poll(), we just add the node.next.
        for (int i = 0; i < Math.min(m * n, k); i++) {
            Data d = queue.poll();
            result.add(Arrays.asList(d.v1, d.v2));
            if (d.nums2Idx < n - 1) {
                int idx = d.nums2Idx + 1;
                queue.offer(new Data(idx, d.v1, nums2[idx]));
            }
        }
        return result;
    }

    class Data {
        int nums2Idx, v1, v2;

        Data(int nums2Idx, int v1, int v2) {
            this.nums2Idx = nums2Idx;
            this.v1 = v1;
            this.v2 = v2;
        }
    }
}
