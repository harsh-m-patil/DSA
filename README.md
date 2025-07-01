# Java Collections for Competitive Programming

---

### 1. ArrayList

> Dynamically resizable array. Good for random access, less efficient for inserts/deletes in the middle.

```java
// Initialization
ArrayList<Integer> list = new ArrayList<>();

// Add elements
list.add(10);
list.add(20);
list.add(1, 15); // Insert at index 1

// Access elements
int first = list.get(0); // O(1)
int size = list.size(); // O(1)

// Remove elements
list.remove(1); // Remove element at index 1, O(n)
list.remove(Integer.valueOf(20)); // Remove by value, O(n)
list.clear(); // Remove all elements, O(n)

// Iterate
for (int num : list) {
    System.out.print(num + " ");
}
// or
for (int i = 0; i < list.size(); i++) {
    System.out.print(list.get(i) + " ");
}
//Check if element exists
boolean contains = list.contains(10); //O(n)

//Sort an ArrayList
Collections.sort(list); //Ascending Order, O(n log n)
Collections.sort(list, Collections.reverseOrder()); //Descending Order
```

---

### 2. LinkedList

> Doubly linked list. Efficient for inserts/deletes at both ends, less efficient for random access.

```java
// Initialization
LinkedList<Integer> list = new LinkedList<>();

// Add elements
list.addFirst(10);
list.addLast(20);
list.add(1, 15);

// Access elements
int first = list.getFirst(); // O(1)
int last = list.getLast(); // O(1)
int elementAtIndex = list.get(2); //O(n)
int size = list.size(); // O(1)

// Remove elements
list.removeFirst(); // O(1)
list.removeLast(); // O(1)
list.remove(1); // Remove from index, O(n)
list.remove(Integer.valueOf(15)); //Remove by value O(n)

// Iterate (same as ArrayList)
for (int num : list) {
    System.out.print(num + " ");
}

//Check if element exists
boolean contains = list.contains(10); //O(n)
When to use: ArrayList for random access, LinkedList for frequent insertions/deletions at the beginning/end.
```

---

### 3. HashMap

> Stores key-value pairs. Provides fast average-case lookup, insertion, and deletion. Keys are unique.

```java
// Initialization
HashMap<String, Integer> map = new HashMap<>();

// Add key-value pairs
map.put("Alice", 25);
map.put("Bob", 30);
map.put("Charlie", 28);

// Access values
int ageOfAlice = map.get("Alice"); // O(1) average, O(n) worst-case
int ageOfDavid = map.getOrDefault("David", 0); // Returns 0 if "David" not found

// Check if key exists
boolean hasAlice = map.containsKey("Alice"); // O(1) average, O(n) worst-case

// Remove key-value pair
map.remove("Bob"); // O(1) average, O(n) worst-case

// Iterate over keys
for (String name : map.keySet()) {
    System.out.print(name + " ");
}

// Iterate over values
for (int age : map.values()) {
    System.out.print(age + " ");
}

// Iterate over key-value pairs
for (Map.Entry<String, Integer> entry : map.entrySet()) {
    System.out.println(entry.getKey() + ": " + entry.getValue());
}
//Get size
int mapSize = map.size();
```

---

### 4. TreeMap

> Stores key-value pairs, sorted by keys. Provides ordered traversal.
> When to use: HashMap for fast average-case operations, TreeMap for sorted keys.

```java
// Initialization
TreeMap<String, Integer> map = new TreeMap<>(); // Sorted by keys

// Add key-value pairs (same as HashMap)
map.put("Charlie", 28);
map.put("Alice", 25);
map.put("Bob", 30);

// Access, check, remove (same as HashMap) - but with sorted keys
int ageOfAlice = map.get("Alice");
boolean hasBob = map.containsKey("Bob");
map.remove("Charlie");

// Iterate (same as HashMap, but sorted)
for (String name : map.keySet()) {
    System.out.print(name + " "); // Output: Alice Bob
}

//Navigating the TreeMap
String firstKey = map.firstKey(); //Returns "Alice"
String lastKey = map.lastKey(); //Returns "Bob"
String lowerKey = map.lowerKey("Bob"); //Returns "Alice"
String higherKey = map.higherKey("Alice"); //Returns "Bob"
```

---

### 5. HashSet

> Stores unique elements. Provides fast average-case lookup, insertion, and deletion.

```java
// Initialization
HashSet<Integer> set = new HashSet<>();

// Add elements
set.add(10);
set.add(20);
set.add(10); // Duplicate, will not be added

// Check if element exists
boolean contains10 = set.contains(10); // O(1) average, O(n) worst-case

// Remove element
set.remove(20); // O(1) average, O(n) worst-case

// Iterate
for (int num : set) {
    System.out.print(num + " ");
}

//Get size of set
int setSize = set.size();

//Check if set is empty
boolean isEmpty = set.isEmpty();

```

---

### 6. PriorityQueue

> A queue where elements are ordered based on priority (naturally or by a Comparator). Implemented as a heap.

```java
// Initialization (Min Heap)
PriorityQueue<Integer> pq = new PriorityQueue<>();

// Initialization (Max Heap) - use a comparator
PriorityQueue<Integer> maxPq = new PriorityQueue<>(Collections.reverseOrder());

// Add elements
pq.offer(30);
pq.offer(10);
pq.offer(20);

// Access minimum element
int min = pq.peek(); // O(1)

// Remove minimum element
int removedMin = pq.poll(); // O(log n)

// Iterate (not in sorted order)
for (int num : pq) {
    System.out.print(num + " ");
}
//Get Size
int pqSize = pq.size();
// Key point: PriorityQueue is a min-heap by default. Use Collections.reverseOrder() for a max-heap.
```

---

## Common DSA Patterns & Algorithms

### 1. Sliding Window

> Efficiently process contiguous subarrays or substrings. Reduces redundant calculations by "sliding" the window.

```java
// Example: Find maximum sum of subarray of size k

int maxSum(int[] arr, int k) {
    int n = arr.length;
    if (n < k) return -1;

    int maxSum = 0;
    for (int i = 0; i < k; i++) {
        maxSum += arr[i];
    }

    int windowSum = maxSum;
    for (int i = k; i < n; i++) {
        windowSum += arr[i] - arr[i - k];
        maxSum = Math.max(maxSum, windowSum);
    }
    return maxSum;

}
```

---

### 2. Two Pointers

> Uses two pointers to iterate through a data structure (usually an array or linked list) in a coordinated way. Useful for problems involving searching, merging, or reversing.

```java
// Example: Check if sorted array has a pair with given sum
boolean hasPair(int[] arr, int targetSum) {
    int left = 0;
    int right = arr.length - 1;
    while (left < right) {
        int currentSum = arr[left] + arr[right];
        if (currentSum == targetSum) {
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

### 3. Backtracking

> Explores all possible solutions by trying different options and undoing them ("backtracking") if they don't lead to a valid solution. Commonly used for problems involving permutations, combinations, and subset generation.

```java
// Example: Generate all permutations of a string
void permute(String str, int l, int r, List<String> result) {
    if (l == r) {
        result.add(str);
        return;
    }
    for (int i = l; i <= r; i++) {
        str = swap(str, l, i);
        permute(str, l + 1, r, result);
        str = swap(str, l, i); // Backtrack
    }
}

String swap(String a, int i, int j) {
    char[] charArray = a.toCharArray();
    char temp = charArray[i];
    charArray[i] = charArray[j];
    charArray[j] = temp;
    return String.valueOf(charArray);
```

}

---

### 4. Divide & Conquer

> Recursively breaks down a problem into smaller subproblems, solves the subproblems, and combines the solutions. Examples: binary search, merge sort, quicksort.

```java
// Example: Binary Search
int binarySearch(int[] arr, int target) {
    int left = 0;
    int right = arr.length - 1;
    while (left <= right) {
        int mid = left + (right - left) / 2; // Avoid overflow
        if (arr[mid] == target) {
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

### 5. Sorting

> Arranges elements in a specific order. Essential for many other algorithms (e.g., searching, merging).Arrays.sort(): For primitive types, uses a variant of quicksort (dual-pivot quicksort). For objects, uses mergesort.Collections.sort(): Uses mergesort.Time Complexity: O(n log n) for efficient algorithms (mergesort, quicksort), O(n^2) for less efficient ones (bubble sort, insertion sort).

```java
// Sort an array of integers
int[] arr = {5, 2, 8, 1, 9};
Arrays.sort(arr); // Ascending order

// Sort a list of integers
List<Integer> list = new ArrayList<>(Arrays.asList(5, 2, 8, 1, 9));
Collections.sort(list); // Ascending order
Collections.sort(list, Collections.reverseOrder()); //Descending order

//Sort a 2D array by the first column
int[][] matrix = {{1, 2}, {4, 5}, {3, 4}};
Arrays.sort(matrix, (a, b) -> Integer.compare(a[0], b[0]));
```

---

### 6. Searching

> Finds a specific element in a data structure.Linear Search: Checks each element sequentially. O(n)Binary Search: Repeatedly divides the search interval in half. Requires sorted data. O(log n)

```java
// Linear Search
int linearSearch(int[] arr, int target) {
    for (int i = 0; i < arr.length; i++) {
        if (arr[i] == target) {
            return i;
        }
    }
    return -1;
}

```

> Binary Search (see Divide & Conquer section)

---

### 7. Binary Tree Traversal

#### BFS

```java
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<List<Integer>> outer = new ArrayList<>();

        if(root == null) {
            return outer;
        }

        q.add(root);

        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> inner = new ArrayList<>();

            for(int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
                inner.add(curr.val);

                if(curr.left != null) {
                    q.add(curr.left);
                }

                if(curr.right != null) {
                    q.add(curr.right);
                }
            }

           outer.add(inner);
        }

        return outer;
    }
}
```

### 8. Graph Traversal

> Systematically visits all vertices in a graph. Used for finding paths, detecting cycles, and exploring graph properties.

```java
import java.util.*;

// Adjacency List Representation
class Graph {
    private int V; // Number of vertices
    private List<List<Integer>> adj; // Adjacency list

    Graph(int v) {
        V = v;
        adj = new ArrayList<>(v);
        for (int i = 0; i < v; ++i)
        adj.add(new ArrayList<>());
    }

    void addEdge(int v, int w) {
        adj.get(v).add(w);
        adj.get(w).add(v); // For undirected graph
    }

    // Breadth-First Search (BFS)
    void BFS(int start) {
        boolean[] visited = new boolean[V];
        Queue<Integer> queue = new LinkedList<>();

        visited[start] = true;
        queue.offer(start);

        while (!queue.isEmpty()) {
            int current = queue.poll();
            System.out.print(current + " ");

            for (int neighbor : adj.get(current)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.offer(neighbor);
                }
            }
        }
    }

    // Depth-First Search (DFS) - Recursive
    void DFS(int start) {
        boolean[] visited = new boolean[V];
        DFSUtil(start, visited);
    }

    void DFSUtil(int v, boolean[] visited) {
        visited[v] = true;
        System.out.print(v + " ");

        for (int neighbor : adj.get(v)) {
            if (!visited[neighbor]) {
                DFSUtil(neighbor, visited);
            }
        }
    }

    //Depth First Search Iterative
    void DFS_Iterative(int start){
        boolean[] visited = new boolean[V];
        Stack<Integer> stack = new Stack<>();
        stack.push(start);

        while(!stack.isEmpty()){
            int current = stack.pop();
            if(!visited[current]){
                visited[current] = true;
                System.out.print(current + " ");
                for(int neighbor: adj.get(current)){
                    if(!visited[neighbor]){
                        stack.push(neighbor);
                    }
                }
            }
        }
    }
}
```

---

### 8. Dynamic Programming

> Solves problems by breaking them down into overlapping subproblems, storing the results of subproblems to avoid redundant computation.

```java
// Example: Fibonacci Numbers (Bottom-up)
int fibonacci(int n) {
    if (n <= 1) return n;
    int[] dp = new int[n + 1];
    dp[0] = 0;
    dp[1] = 1;
    for (int i = 2; i <= n; i++) {
        dp[i] = dp[i - 1] + dp[i - 2];
    }
    return dp[n];
}

// Example: Fibonacci Numbers (Top-down with Memoization)
int fibonacciMemo(int n, int[] memo) {
    if (n <= 1) return n;
    if (memo[n] != -1) return memo[n];
    memo[n] = fibonacciMemo(n - 1, memo) + fibonacciMemo(n - 2, memo);
    return memo[n];
}

//Driver code for Memoization
int n = 10;
int[] memo = new int[n + 1];
Arrays.fill(memo, -1);
int result = fibonacciMemo(n,memo);
```

---

### 10. Kadane's Algorithm

> Finds the maximum sum of a contiguous subarray in a one-dimensional array.

```java
// Example: Find maximum sum of a contiguous subarray
int kadane(int[] arr) {
    int maxSoFar = Integer.MIN_VALUE;
    int maxEndingHere = 0;

    for (int num : arr) {
        maxEndingHere = Math.max(num, maxEndingHere + num);
        maxSoFar = Math.max(maxSoFar, maxEndingHere);
    }
    return maxSoFar;
}
```

---

### 10. Floyd's Cycle-Finding Algorithm

> Detects cycles in a linked list. Uses two pointers, one moving slowly and one moving quickly.

```java
// Example: Detect a cycle in a linked list
class ListNode {
    int val;
    ListNode next;
    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

boolean hasCycle(ListNode head) {
    if (head == null || head.next == null) return false;

    ListNode slow = head;
    ListNode fast = head.next;

    while (fast != null && fast.next != null) {
        if (slow == fast) return true;
        slow = slow.next;
        fast = fast.next.next;
    }
    return false;
}
```

---

### 12. Prefix Sum

> Calculates the cumulative sum of elements up to each index in an array. Allows for efficient calculation of sums of subarrays.

```java
// Example: Calculate prefix sum array
int[] prefixSum(int[] arr) {
    int n = arr.length;
    int[] prefix = new int[n];
    prefix[0] = arr[0];
    for (int i = 1; i < n; i++) {
        prefix[i] = prefix[i - 1] + arr[i];
    }
    return prefix;
}

// Example: Use prefix sum to find sum of range [l, r] (0-indexed)
int rangeSum(int[] prefix, int l, int r) {
    if (l == 0) return prefix[r];
    return prefix[r] - prefix[l - 1];
}
```

---

### 13. Iterative DFS

> Performs Depth-First Search using a stack instead of recursion.

```java
import java.util.*;

// Adjacency List Representation
class Graph {
    private int V; // Number of vertices
    private List<List<Integer>> adj; // Adjacency list

    Graph(int v) {
        V = v;
        adj = new ArrayList<>(v);
        for (int i = 0; i < v; ++i)
        adj.add(new ArrayList<>());
    }

    void addEdge(int v, int w) {
        adj.get(v).add(w);
        adj.get(w).add(v); // For undirected graph
    }

    //Depth First Search Iterative
    void DFS_Iterative(int start){
        boolean[] visited = new boolean[V];
        Stack<Integer> stack = new Stack<>();
        stack.push(start);

        while(!stack.isEmpty()){
            int current = stack.pop();
            if(!visited[current]){
                visited[current] = true;
                System.out.print(current + " ");
                for(int neighbor: adj.get(current)){
                    if(!visited[neighbor]){
                        stack.push(neighbor);
                    }
                }
            }
        }
    }

}

```

---

### 13. Subsets

> Generates all possible subsets of a given set.

```java
// Example: Generate all subsets of a set
List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    generateSubsets(nums, 0, new ArrayList<>(), result);
    return result;
}

void generateSubsets(int[] nums, int index, List<Integer> current, List<List<Integer>> result) {
    result.add(new ArrayList<>(current)); // Add the current subset

    for (int i = index; i < nums.length; i++) {
        current.add(nums[i]);
        generateSubsets(nums, i + 1, current, result);
        current.remove(current.size() - 1); // Backtrack
    }

}
```

---

### 15. Combinations

> Generates all possible combinations of a specified size from a given set.

```java
// Example: Generate all combinations of size k from a set of size n
List<List<Integer>> combinations(int n, int k) {
    List<List<Integer>> result = new ArrayList<>();
    generateCombinations(n, k, 1, new ArrayList<>(), result);
    return result;
}

void generateCombinations(int n, int k, int start, List<Integer> current, List<List<Integer>> result) {
    if (current.size() == k) {
        result.add(new ArrayList<>(current));
        return;
    }

    for (int i = start; i <= n; i++) {
        current.add(i);
        generateCombinations(n, k, i + 1, current, result);
        current.remove(current.size() - 1); // Backtrack
    }

}
```

---

### 16. Permutations

> Generates all possible orderings (permutations) of the elements of a set.

```java
import java.util.ArrayList;
import java.util.List;

// Example: Generate all permutations of a set
List<List<Integer>> permutations(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    generatePermutations(nums, new ArrayList<>(), new boolean[nums.length], result);
    return result;
}

void generatePermutations(int[] nums, List<Integer> current, boolean[] used, List<List<Integer>> result) {
    if (current.size() == nums.length) {
        result.add(new ArrayList<>(current));
        return;
    }

    for (int i = 0; i < nums.length; i++) {
        if (!used[i]) {
            used[i] = true;
            current.add(nums[i]);
            generatePermutations(nums, current, used, result);
            current.remove(current.size() - 1); // Backtrack
            used[i] = false;
        }
    }

}
```

---

### 17. Subarray

> A contiguous part of an array. The following shows how to extract a subarray.

```java
// Example: Get a subarray using Arrays.copyOfRange
int[] arr = {1, 2, 3, 4, 5};
int start = 1;
int end = 4; // Exclusive
int[] subArray = Arrays.copyOfRange(arr, start, end); // {2, 3, 4}

```

### 18. Bit Manipulation

> Efficiently performs operations on binary representations of integers. Common operations include AND, OR, XOR, NOT, and bit shifts.

```java
// Example: Check if a number is even or odd
int num = 5;
boolean isEven = (num & 1) == 0; // Even if last bit is 0
boolean isOdd = (num & 1) == 1; // Odd if last bit is 1
// Example: Count the number of set bits (1s) in an integer
int countSetBits(int n) {
    int count = 0;
    while (n > 0) {
        count += n & 1; // Increment count if last bit is 1
        n >>= 1; // Right shift to check next bit
    }
    return count;
}
// Example: Swap two numbers without a temporary variable
int a = 5;
int b = 10;
a = a ^ b; // Step 1: a now holds the XOR of a and b
b = a ^ b; // Step 2: b now holds the original value of a
a = a ^ b; // Step 3: a now holds the original value of b

// Example: Check if a number is a power of 2
boolean isPowerOfTwo(int n) {
    return (n > 0) && ((n & (n - 1)) == 0); // A power of 2 has only one bit set
}
// Example: Find the unique number in an array where every other number appears twice
int findUnique(int[] arr) {
    int unique = 0;
    for (int num : arr) {
        unique ^= num; // XOR all numbers, duplicates cancel out
    }
    return unique;
}

// Example: Left shift and right shift
int leftShift = 5 << 1; // Multiplies by 2
int rightShift = 5 >> 1; // Divides by 2

```
