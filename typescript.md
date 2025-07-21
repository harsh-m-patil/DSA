# TypeScript Collections & DSA Patterns Reference

---

## 1. Arrays

> Dynamically sized, fast random access, many built-in methods.

```typescript
// Initialization
const arr: number[] = [];
const arr2 = [10, 20, 30];

// Add elements
arr.push(10);
arr.push(20);
arr.splice(1, 0, 15); // Insert 15 at index 1

// Access elements
const first = arr[0]; // O(1)
const size = arr.length; // O(1)

// Remove elements
arr.splice(1, 1); // Remove element at index 1
arr.pop(); // Remove last element
arr.shift(); // Remove first element
arr.length = 0; // Clear all elements

// Iterate
for (const num of arr) {
  console.log(num);
}
// or
for (let i = 0; i < arr.length; i++) {
  console.log(arr[i]);
}

// Check if element exists
const contains = arr.includes(10); // O(n)

// Sort an array
arr.sort((a, b) => a - b); // Ascending
arr.sort((a, b) => b - a); // Descending
```

---

## 2. Linked List (Singly)

> Efficient for inserts/deletes at both ends, less efficient for random access. No built-in linked list in JS/TS, so implement manually.

```typescript
class ListNode {
  val: number;
  next: ListNode | null;
  constructor(val: number) {
    this.val = val;
    this.next = null;
  }
}

// Build a linked list: 10 -> 15 -> 20
const head = new ListNode(10);
head.next = new ListNode(15);
head.next.next = new ListNode(20);

// Iterate
let curr: ListNode | null = head;
while (curr) {
  console.log(curr.val);
  curr = curr.next;
}

// Insert at beginning
const newHead = new ListNode(5);
newHead.next = head;

// Remove first element
const afterRemove = newHead.next;
```

---

## 3. Map (HashMap/TreeMap)

> Stores key-value pairs. Fast average-case lookup, insertion, and deletion. Keys are unique. JS/TS Map preserves insertion order; for sorted keys, sort manually.

```typescript
// Initialization
const map = new Map<string, number>();

// Add key-value pairs
map.set('Alice', 25);
map.set('Bob', 30);
map.set('Charlie', 28);

// Access values
const ageOfAlice = map.get('Alice'); // undefined if not found
const ageOfDavid = map.get('David') ?? 0; // Returns 0 if not found

// Check if key exists
const hasAlice = map.has('Alice');

// Remove key-value pair
map.delete('Bob');

// Iterate over keys
for (const name of map.keys()) {
  console.log(name);
}

// Iterate over values
for (const age of map.values()) {
  console.log(age);
}

// Iterate over key-value pairs
for (const [name, age] of map.entries()) {
  console.log(`${name}: ${age}`);
}

// Get size
const mapSize = map.size;

// Sort by key (returns array)
const sortedEntries = Array.from(map.entries()).sort((a, b) => a[0].localeCompare(b[0]));
```

---

## 4. Set

> Stores unique elements. Fast average-case lookup, insertion, and deletion.

```typescript
// Initialization
const set = new Set<number>();

// Add elements
set.add(10);
set.add(20);
set.add(10); // Duplicate, will not be added

// Check if element exists
const contains10 = set.has(10);

// Remove element
set.delete(20);

// Iterate
for (const num of set) {
  console.log(num);
}

// Get size
const setSize = set.size;

// Check if set is empty
const isEmpty = set.size === 0;
```

---

## 5. Priority Queue (Heap)

> No built-in PriorityQueue in JS/TS. Use a custom class or external library. Here’s a simple min-heap implementation:

```typescript
class MinHeap {
  heap: number[] = [];

  insert(val: number) {
    this.heap.push(val);
    this.bubbleUp();
  }

  bubbleUp() {
    let idx = this.heap.length - 1;
    while (idx > 0) {
      const parent = Math.floor((idx - 1) / 2);
      if (this.heap[parent] > this.heap[idx]) {
        [this.heap[parent], this.heap[idx]] = [this.heap[idx], this.heap[parent]];
        idx = parent;
      } else break;
    }
  }

  extractMin(): number | undefined {
    if (this.heap.length === 0) return undefined;
    const min = this.heap[0];
    const end = this.heap.pop()!;
    if (this.heap.length > 0) {
      this.heap[0] = end;
      this.sinkDown(0);
    }
    return min;
  }

  sinkDown(idx: number) {
    const length = this.heap.length;
    while (true) {
      let left = 2 * idx + 1;
      let right = 2 * idx + 2;
      let smallest = idx;
      if (left < length && this.heap[left] < this.heap[smallest]) smallest = left;
      if (right < length && this.heap[right] < this.heap[smallest]) smallest = right;
      if (smallest === idx) break;
      [this.heap[smallest], this.heap[idx]] = [this.heap[idx], this.heap[smallest]];
      idx = smallest;
    }
  }

  peek(): number | undefined {
    return this.heap[0];
  }

  size(): number {
    return this.heap.length;
  }
}

// Usage
const pq = new MinHeap();
pq.insert(30);
pq.insert(10);
pq.insert(20);
console.log(pq.peek()); // 10
console.log(pq.extractMin()); // 10
console.log(pq.size()); // 2
```

---

## 6. Common DSA Patterns & Algorithms

### Sliding Window

> Efficiently process contiguous subarrays or substrings.

```typescript
// Example: Find maximum sum of subarray of size k
function maxSum(arr: number[], k: number): number {
  const n = arr.length;
  if (n < k) return -1;
  let maxSum = 0;
  for (let i = 0; i < k; i++) {
    maxSum += arr[i];
  }
  let windowSum = maxSum;
  for (let i = k; i < n; i++) {
    windowSum += arr[i] - arr[i - k];
    maxSum = Math.max(maxSum, windowSum);
  }
  return maxSum;
}
```

---

### Two Pointers

> Uses two pointers to iterate through a data structure in a coordinated way.

```typescript
// Example: Check if sorted array has a pair with given sum
function hasPair(arr: number[], targetSum: number): boolean {
  let left = 0;
  let right = arr.length - 1;
  while (left < right) {
    const currentSum = arr[left] + arr[right];
    if (currentSum === targetSum) {
      return true;
    } else if (currentSum < targetSum) {
      left++;
    } else {
      right--;
    }
  }
  return false;
}
```

---

### Backtracking

> Explores all possible solutions by trying different options and undoing them if they don't lead to a valid solution.

```typescript
// Example: Generate all permutations of a string
function permute(str: string, l: number, r: number, result: string[]): void {
  if (l === r) {
    result.push(str);
    return;
  }
  for (let i = l; i <= r; i++) {
    str = swap(str, l, i);
    permute(str, l + 1, r, result);
    str = swap(str, l, i); // Backtrack
  }
}

function swap(a: string, i: number, j: number): string {
  const arr = a.split('');
  [arr[i], arr[j]] = [arr[j], arr[i]];
  return arr.join('');
}
```

---

### Divide & Conquer

> Recursively breaks down a problem into smaller subproblems, solves the subproblems, and combines the solutions.

```typescript
// Example: Binary Search
function binarySearch(arr: number[], target: number): number {
  let left = 0;
  let right = arr.length - 1;
  while (left <= right) {
    const mid = left + Math.floor((right - left) / 2);
    if (arr[mid] === target) {
      return mid;
    } else if (arr[mid] < target) {
      left = mid + 1;
    } else {
      right = mid - 1;
    }
  }
  return -1;
}
```

---

### Sorting

> Arranges elements in a specific order. Essential for many algorithms.

```typescript
// Sort an array of numbers
const arr = [5, 2, 8, 1, 9];
arr.sort((a, b) => a - b); // Ascending
arr.sort((a, b) => b - a); // Descending

// Sort an array of objects by a property
const people = [
  { name: 'Alice', age: 25 },
  { name: 'Bob', age: 30 },
  { name: 'Charlie', age: 28 }
];
people.sort((a, b) => a.age - b.age); // Ascending by age

// Sort a 2D array by the first column
const matrix = [[1, 2], [4, 5], [3, 4]];
matrix.sort((a, b) => a[0] - b[0]);
```

---

### Searching

> Finds a specific element in a data structure.

```typescript
// Linear Search
function linearSearch(arr: number[], target: number): number {
  for (let i = 0; i < arr.length; i++) {
    if (arr[i] === target) {
      return i;
    }
  }
  return -1;
}
```

---

### Binary Tree Traversal (BFS)

> Level order traversal using a queue.

```typescript
class TreeNode {
  val: number;
  left: TreeNode | null;
  right: TreeNode | null;
  constructor(val: number) {
    this.val = val;
    this.left = null;
    this.right = null;
  }
}

function levelOrder(root: TreeNode | null): number[][] {
  const result: number[][] = [];
  if (!root) return result;
  const queue: TreeNode[] = [root];
  while (queue.length) {
    const size = queue.length;
    const level: number[] = [];
    for (let i = 0; i < size; i++) {
      const node = queue.shift()!;
      level.push(node.val);
      if (node.left) queue.push(node.left);
      if (node.right) queue.push(node.right);
    }
    result.push(level);
  }
  return result;
}
```

---

### Graph Traversal (BFS & DFS)

> Systematically visits all vertices in a graph.

```typescript
// Adjacency List Representation
class Graph {
  adj: number[][];
  V: number;
  constructor(v: number) {
    this.V = v;
    this.adj = Array.from({ length: v }, () => []);
  }
  addEdge(v: number, w: number) {
    this.adj[v].push(w);
    this.adj[w].push(v); // For undirected graph
  }
  // Breadth-First Search (BFS)
  BFS(start: number) {
    const visited = Array(this.V).fill(false);
    const queue: number[] = [];
    visited[start] = true;
    queue.push(start);
    while (queue.length) {
      const current = queue.shift()!;
      console.log(current);
      for (const neighbor of this.adj[current]) {
        if (!visited[neighbor]) {
          visited[neighbor] = true;
          queue.push(neighbor);
        }
      }
    }
  }
  // Depth-First Search (DFS) - Recursive
  DFS(start: number) {
    const visited = Array(this.V).fill(false);
    this.DFSUtil(start, visited);
  }
  DFSUtil(v: number, visited: boolean[]) {
    visited[v] = true;
    console.log(v);
    for (const neighbor of this.adj[v]) {
      if (!visited[neighbor]) {
        this.DFSUtil(neighbor, visited);
      }
    }
  }
  // Depth-First Search (DFS) - Iterative
  DFS_Iterative(start: number) {
    const visited = Array(this.V).fill(false);
    const stack: number[] = [start];
    while (stack.length) {
      const current = stack.pop()!;
      if (!visited[current]) {
        visited[current] = true;
        console.log(current);
        for (const neighbor of this.adj[current]) {
          if (!visited[neighbor]) {
            stack.push(neighbor);
          }
        }
      }
    }
  }
}
```

---

### Dynamic Programming

> Solves problems by breaking them down into overlapping subproblems, storing results to avoid redundant computation.

```typescript
// Example: Fibonacci Numbers (Bottom-up Tabulation)
function fibonacci(n: number): number {
  if (n <= 1) return n;
  const dp = Array(n + 1).fill(0);
  dp[1] = 1;
  for (let i = 2; i <= n; i++) {
    dp[i] = dp[i - 1] + dp[i - 2];
  }
  return dp[n];
}

// Example: Fibonacci Numbers (Top-down Memoization)
function fibonacciMemo(n: number, memo: number[]): number {
  if (n <= 1) return n;
  if (memo[n] !== -1) return memo[n];
  memo[n] = fibonacciMemo(n - 1, memo) + fibonacciMemo(n - 2, memo);
  return memo[n];
}

// Driver code for Memoization
const n = 10;
const memo = Array(n + 1).fill(-1);
const result = fibonacciMemo(n, memo);
```

---

### Kadane's Algorithm

> Finds the maximum sum of a contiguous subarray in a one-dimensional array.

```typescript
function kadane(arr: number[]): number {
  let maxSoFar = -Infinity;
  let maxEndingHere = 0;
  for (const num of arr) {
    maxEndingHere = Math.max(num, maxEndingHere + num);
    maxSoFar = Math.max(maxSoFar, maxEndingHere);
  }
  return maxSoFar;
}
```

---

### Floyd's Cycle-Finding Algorithm

> Detects cycles in a linked list. Uses two pointers, one moving slowly and one quickly.

```typescript
class ListNode {
  val: number;
  next: ListNode | null;
  constructor(val: number) {
    this.val = val;
    this.next = null;
  }
}

function hasCycle(head: ListNode | null): boolean {
  if (!head || !head.next) return false;
  let slow: ListNode | null = head;
  let fast: ListNode | null = head.next;
  while (fast && fast.next) {
    if (slow === fast) return true;
    slow = slow.next;
    fast = fast.next.next;
  }
  return false;
}
```

---

### Prefix Sum

> Calculates the cumulative sum of elements up to each index in an array.

```typescript
// Calculate prefix sum array
function prefixSum(arr: number[]): number[] {
  const n = arr.length;
  const prefix = Array(n).fill(0);
  prefix[0] = arr[0];
  for (let i = 1; i < n; i++) {
    prefix[i] = prefix[i - 1] + arr[i];
  }
  return prefix;
}

// Use prefix sum to find sum of range [l, r] (0-indexed)
function rangeSum(prefix: number[], l: number, r: number): number {
  if (l === 0) return prefix[r];
  return prefix[r] - prefix[l - 1];
}
```

---

### Subsets

> Generates all possible subsets of a given set.

```typescript
function subsets(nums: number[]): number[][] {
  const result: number[][] = [];
  function backtrack(index: number, current: number[]) {
    result.push([...current]);
    for (let i = index; i < nums.length; i++) {
      current.push(nums[i]);
      backtrack(i + 1, current);
      current.pop(); // Backtrack
    }
  }
  backtrack(0, []);
  return result;
}
```

---

### Combinations

> Generates all possible combinations of a specified size from a given set.

```typescript
function combinations(n: number, k: number): number[][] {
  const result: number[][] = [];
  function backtrack(start: number, current: number[]) {
    if (current.length === k) {
      result.push([...current]);
      return;
    }
    for (let i = start; i <= n; i++) {
      current.push(i);
      backtrack(i + 1, current);
      current.pop(); // Backtrack
    }
  }
  backtrack(1, []);
  return result;
}
```

---

### Permutations

> Generates all possible orderings (permutations) of the elements of a set.

```typescript
function permutations(nums: number[]): number[][] {
  const result: number[][] = [];
  const used = Array(nums.length).fill(false);
  function backtrack(current: number[]) {
    if (current.length === nums.length) {
      result.push([...current]);
      return;
    }
    for (let i = 0; i < nums.length; i++) {
      if (!used[i]) {
        used[i] = true;
        current.push(nums[i]);
        backtrack(current);
        current.pop(); // Backtrack
        used[i] = false;
      }
    }
  }
  backtrack([]);
  return result;
}
```

---

### Subarray Extraction

> A contiguous part of an array.

```typescript
const arr = [1, 2, 3, 4, 5];
const start = 1;
const end = 4; // Exclusive
const subArray = arr.slice(start, end); // [2, 3, 4]
```

---

### Bit Manipulation

> Efficiently performs operations on binary representations of integers.

```typescript
// Check if a number is even or odd
const num = 5;
const isEven = (num & 1) === 0;
const isOdd = (num & 1) === 1;

// Count the number of set bits (1s) in an integer
function countSetBits(n: number): number {
  let count = 0;
  while (n > 0) {
    count += n & 1;
    n >>= 1;
  }
  return count;
}

// Swap two numbers without a temporary variable
let a = 5, b = 10;
a = a ^ b;
b = a ^ b;
a = a ^ b;

// Check if a number is a power of 2
function isPowerOfTwo(n: number): boolean {
  return n > 0 && (n & (n - 1)) === 0;
}

// Find the unique number in an array where every other number appears twice
function findUnique(arr: number[]): number {
  let unique = 0;
  for (const num of arr) {
    unique ^= num;
  }
  return unique;
}

// Left shift and right shift
const leftShift = 5 << 1; // Multiplies by 2
const rightShift = 5 >> 1; // Divides by 2
```

---
