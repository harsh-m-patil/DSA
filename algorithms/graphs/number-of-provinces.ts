// LeetCode Problem: https://leetcode.com/problems/number-of-provinces/
// Time Complexity: O(V + E) where V is the number of vertices and E is the number of edges
// Space Complexity: O(V) for the visited set and graph representation
// This function counts the number of connected components (provinces) in an undirected graph represented by an adjacency matrix.
// It uses Depth-First Search (DFS) to explore each component and mark nodes as visited.
// The input is a 2D array where isConnected[i][j] = 1 means there is a direct connection between province i and province j.
// The function returns the number of connected components (provinces) in the graph.

function findCircleNum(isConnected: number[][]): number {
  const graph: Record<number, number[]> = {};
  const visited = new Set<number>();
  let count = 0;

  for (let i = 0; i < isConnected.length; i++) {
    for (let j = 0; j < isConnected[i].length; j++) {
      if (!graph[i]) graph[i] = [];
      if (!graph[j]) graph[j] = [];

      if (isConnected[i][j]) {
        graph[i].push(j);
        graph[j].push(i);
      }
    }
  }

  for (const nodestr in graph) {
    const node = Number(nodestr);
    if (visited.has(node)) continue;
    dfs(graph, node, visited);
    count++;
  }

  return count;
}

function dfs(
  graph: Record<number, number[]>,
  node: number,
  visited: Set<number>,
) {
  const stack = [node];

  while (stack.length > 0) {
    const current = stack.pop()!;
    if (visited.has(current)) continue;
    visited.add(current);

    for (let neighbor of graph[current]) {
      if (!visited.has(neighbor)) stack.push(neighbor);
    }
  }
}
