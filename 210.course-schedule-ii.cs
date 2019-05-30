/*
 * @lc app=leetcode id=210 lang=csharp
 *
 * [210] Course Schedule II
 */
public class Solution
{
    public int[] FindOrder(int numCourses, int[][] prerequisites)
    {
        int[] indegree = new int[numCourses];

        // convert edge list to adjacency list
        List<int>[] adjacencyList = new List<int>[numCourses];

        for (int i = 0; i < numCourses; i++)
        {
            adjacencyList[i] = new List<int>();
        }

        // init adjacency list and indegree array
        foreach (var edge in prerequisites)
        {
            indegree[edge[0]]++;
            adjacencyList[edge[1]].Add(edge[0]);
        }

        Queue<int> zeroIndegree = new Queue<int>();
        List<int> topoSortList = new List<int>();

        // queue zero indegree vertex
        for (int i = 0; i < numCourses; i++)
        {
            if (indegree[i] == 0) zeroIndegree.Enqueue(i);
        }

        while (zeroIndegree.Count > 0)
        {
            var node = zeroIndegree.Dequeue();
            numCourses--;
            topoSortList.Add(node);

            foreach (var neibo in adjacencyList[node])
            {
                indegree[neibo]--;

                if (indegree[neibo] == 0)
                {
                    zeroIndegree.Enqueue(neibo);
                }
            }
        }

        return numCourses == 0 ? topoSortList.ToArray() : new int[] { };
    }
}

