package algorithms.heaps;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.PriorityQueue;

class Solution {
  public int[] topKFrequent(int[] nums, int k) {
    // map to store count of each el
    Map<Integer, Integer> map = new HashMap<>();

    // add to map
    for (int num : nums) {
      map.put(num, map.getOrDefault(num, 0) + 1);
    }

    // pq to get top k elements according to count
    PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(
        (a, b) -> Integer.compare(b.getValue(), a.getValue()));

    // add entries to pq
    for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
      pq.offer(entry);
    }

    int[] res = new int[k];

    // get top k entries
    for (int i = 0; i < k; i++) {
      res[i] = Objects.requireNonNull((pq.poll()).getKey());
    }

    return res;
  }
}
