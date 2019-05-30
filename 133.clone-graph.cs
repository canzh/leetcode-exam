/*
 * @lc app=leetcode id=133 lang=csharp
 *
 * [133] Clone Graph
 */
/*
// Definition for a Node.
public class Node {
    public int val;
    public IList<Node> neighbors;

    public Node(){}
    public Node(int _val,IList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
}
*/
public class Solution
{
    Dictionary<int, Node> visitedMap = new Dictionary<int, Node>();

    public Node CloneGraph(Node node)
    {
        if (node == null) return node;

        if (visitedMap.ContainsKey(node.val)) return visitedMap[node.val];

        Node newNode = new Node();
        newNode.val = node.val;
        newNode.neighbors = new List<Node>();

        visitedMap.Add(newNode.val, newNode);

        foreach (var n in node.neighbors)
        {
            newNode.neighbors.Add(CloneGraph(n));
        }

        return newNode;
    }
}

