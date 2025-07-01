type GraphNode = string;
type Graph = Record<GraphNode, readonly string[]>;

const graph: Graph = {
  a: ["b", "c"],
  b: ["d"],
  c: ["e"],
  d: ["f"],
  e: [],
  f: [],
};

// Time Complexity: O(V + E) where V is the number of vertices and E is the number of edges
// Space Complexity: O(V) for the stack in the worst case
const dfs = (graph: Graph, source: GraphNode) => {
  const stack = [source];
  const res: string[] = [];

  while (stack.length > 0) {
    const curr = stack.pop()!;
    res.push(curr);
    for (let neighbor of graph[curr]) {
      stack.push(neighbor);
    }
  }

  return res;
};

// Time Complexity: O(V + E) where V is the number of vertices and E is the number of edges
// Space Complexity: O(V) for the stack in the worst case
const dfsRecursive = (graph: Graph, source: GraphNode, res: string[] = []) => {
  res.push(source);
  for (let neighbor of graph[source]) {
    dfsRecursive(graph, neighbor, res);
  }

  return res;
};

// Time Complexity: O(V + E) where V is the number of vertices and E is the number of edges
// Space Complexity: O(V) for the queue in the worst case
const bfs = (graph: Graph, source: GraphNode) => {
  const queue = [source];
  const res: string[] = [];

  while (queue.length > 0) {
    const curr = queue.shift()!;
    res.push(curr);
    for (let neighbor of graph[curr]) {
      queue.push(neighbor);
    }
  }

  return res;
};

console.log("DFS Iterative:");
console.log(dfs(graph, "a"));
console.log("DFS Recursive:");
console.log(dfsRecursive(graph, "a"));
console.log("Breadth First Search");
console.log(bfs(graph, "a"));
