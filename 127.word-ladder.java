import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/*
 * @lc app=leetcode id=127 lang=java
 *
 * [127] Word Ladder
 *
 * https://leetcode.com/problems/word-ladder/description/
 *
 * algorithms
 * Medium (23.96%)
 * Likes:    1595
 * Dislikes: 841
 * Total Accepted:    276.2K
 * Total Submissions: 1.1M
 * Testcase Example:  '"hit"\n"cog"\n["hot","dot","dog","lot","log","cog"]'
 *
 * Given two words (beginWord and endWord), and a dictionary's word list, find
 * the length of shortest transformation sequence from beginWord to endWord,
 * such that:
 * 
 * 
 * Only one letter can be changed at a time.
 * Each transformed word must exist in the word list. Note that beginWord is
 * not a transformed word.
 * 
 * 
 * Note:
 * 
 * 
 * Return 0 if there is no such transformation sequence.
 * All words have the same length.
 * All words contain only lowercase alphabetic characters.
 * You may assume no duplicates in the word list.
 * You may assume beginWord and endWord are non-empty and are not the same.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 * 
 * Output: 5
 * 
 * Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" ->
 * "dog" -> "cog",
 * return its length 5.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 * 
 * Output: 0
 * 
 * Explanation: The endWord "cog" is not in wordList, therefore no possible
 * transformation.
 * 
 * 
 * 
 * 
 * 
 */
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord))
            return 0;

        Map<String, List<String>> graph = buildGraph(beginWord, wordList);
        return bfs(graph, beginWord, endWord);
    }

    int bfs(Map<String, List<String>> graph, String begin, String end) {
        Set<String> visited = new HashSet<>(graph.size());
        Map<String, Integer> distanceMap = new HashMap<>(graph.size());
        Queue<String> queue = new LinkedList<>();

        distanceMap.putIfAbsent(begin, 0);
        queue.offer(begin);
        visited.add(begin);

        while (!queue.isEmpty()) {
            String w = queue.poll();

            for (String neigbor : graph.get(w)) {
                if (!visited.contains(neigbor)) {
                    visited.add(neigbor);
                    queue.offer(neigbor);

                    distanceMap.put(neigbor, distanceMap.get(w) + 1);

                    if (end.equals(neigbor))
                        break;
                }
            }
        }

        if (distanceMap.containsKey(end))
            return distanceMap.get(end) + 1;

        return 0;
    }

    Map<String, List<String>> buildGraph(String beginWord, List<String> dict) {
        Map<String, List<String>> map = new HashMap<>();
        dict.add(beginWord);

        for (String w : dict) {
            map.putIfAbsent(w, new LinkedList<String>());

            for (String w2 : dict) {
                if (w2.equals(w))
                    continue;

                if (isNeigbor(w, w2)) {
                    map.get(w).add(w2);
                }
            }
        }

        return map;
    }

    boolean isNeigbor(String a, String b) {
        if (a.length() != b.length())
            return false;

        int diff = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i))
                diff++;
        }

        return diff == 1;
    }
}
