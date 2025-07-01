// LeetCode 1971 - Check if Path Exists in Graph
// Time Complexity: O(V + E) where V is the number of vertices and E is the number of edges
// Space Complexity: O(V) for the stack in the worst case
function validPath(
  n: number,
  edges: number[][],
  source: number,
  destination: number,
): boolean {
  const graph: Record<number, number[]> = {};

  for (const [u, v] of edges) {
    if (!graph[u]) graph[u] = [];
    if (!graph[v]) graph[v] = [];
    graph[u].push(v);
    graph[v].push(u);
  }

  const visited = new Set<number>();
  const stack = [source];

  while (stack.length > 0) {
    const curr = stack.pop()!;
    if (curr === destination) return true;
    if (visited.has(curr)) continue;

    visited.add(curr);

    for (let neighbor of graph[curr]) {
      if (!visited.has(neighbor)) stack.push(neighbor);
    }
  }

  return false;
}
