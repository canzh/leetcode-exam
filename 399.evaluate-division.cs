/*
 * @lc app=leetcode id=399 lang=csharp
 *
 * [399] Evaluate Division
 */
public class Solution
{
    public double[] CalcEquation(IList<IList<string>> equations, double[] values, IList<IList<string>> queries)
    {
        Dictionary<string, Dictionary<string, double>> graph = new Dictionary<string, Dictionary<string, double>>();

        // convert to adjacency list representation
        for (int i = 0; i < equations.Count; i++)
        {
            var a = equations[i][0];
            var b = equations[i][1];

            // a -> b
            if (!graph.ContainsKey(a))
            {
                graph.Add(a, new Dictionary<string, double>());
            }
            graph[a].Add(b, values[i]);

            // b -> a
            if (!graph.ContainsKey(b))
            {
                graph.Add(b, new Dictionary<string, double>());
            }
            graph[b].Add(a, 1 / values[i]);

            if (!graph[a].ContainsKey(a))
                graph[a].Add(a, 1.0);
            if (!graph[b].ContainsKey(b))
                graph[b].Add(b, 1.0);
        }

        Dictionary<string, Dictionary<string, double>> temp = new Dictionary<string, Dictionary<string, double>>();

        // floyd like calculation
        foreach (var k in graph.Keys)
        {
            foreach (var i in graph[k].Keys)
            {
                foreach (var j in graph[k].Keys)
                {
                    if (!temp.ContainsKey(i))
                    {
                        temp.Add(i, new Dictionary<string, double>());
                    }

                    if (!temp[i].ContainsKey(j))
                        temp[i].Add(j, graph[i][k] * graph[k][j]);
                }
            }
        }

        // merge records
        foreach (var pair in temp)
        {
            if (!graph.ContainsKey(pair.Key))
            {
                graph.Add(pair.Key, new Dictionary<string, double>());
            }

            foreach (var innerPair in pair.Value)
            {
                if (!graph[pair.Key].ContainsKey(innerPair.Key))
                    graph[pair.Key].Add(innerPair.Key, innerPair.Value);
            }
        }

        List<double> result = new List<double>();

        foreach (var query in queries)
        {
            if (graph.ContainsKey(query[0]) && graph[query[0]].ContainsKey(query[1]))
            {
                result.Add(graph[query[0]][query[1]]);
            }
            else
            {
                result.Add(-1.0);
            }
        }

        return result.ToArray();
    }
}

