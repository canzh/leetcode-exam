/*
 * @lc app=leetcode id=310 lang=csharp
 *
 * [310] Minimum Height Trees
 */
public class Solution
{
    public IList<int> FindMinHeightTrees(int n, int[][] edges)
    {
        if (n == 1) return new List<int> { { 0 } };

        // convert to adjacency list

        List<int>[] adjList = new List<int>[n];
        for (int i = 0; i < n; i++)
        {
            adjList[i] = new List<int>();
        }

        foreach (var edge in edges)
        {
            adjList[edge[0]].Add(edge[1]);
            adjList[edge[1]].Add(edge[0]);
        }

        List<int> leaves = new List<int>();

        for (int i = 0; i < n; i++)
        {
            if (adjList[i].Count == 1) leaves.Add(i);
        }

        while (n > 2)
        {
            n -= leaves.Count;
            List<int> newLeaves = new List<int>();

            foreach (var l in leaves)
            {
                var m = adjList[l][0];
                adjList[m].Remove(l);

                if (adjList[m].Count == 1) newLeaves.Add(m);
            }

            leaves = newLeaves;
        }

        return leaves;
    }
}

