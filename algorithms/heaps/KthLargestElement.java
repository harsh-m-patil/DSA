class KthLargest {
  PriorityQueue<Integer> pq;
  int k;
  public KthLargest(int k, int[] nums) {
    this.pq = new PriorityQueue<>();
    this.k = k;

    for (int num : nums) {
      this.pq.offer(num);
      // NOTE: we only need top k elements therefore remove other elements
      if (this.pq.size() > k) {
        this.pq.poll();
      }
    }
  }

  public int add(int val) {
    this.pq.offer(val);
    // To maintain top k
    if (this.pq.size() > k) {
      this.pq.poll();
    }

    return this.pq.peek();
  }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */

// NOTE: Sort everytime O(nlogn) for sorting for m insertions O(m*nlogn)
// class KthLargest {
//     List<Integer> li;
//     int k;
//     public KthLargest(int k, int[] nums) {
//         this.li = new ArrayList<>();
//         this.k = k;
//
//         Arrays.sort(nums);
//
//         for(int num : nums) {
//             this.li.add(num);
//         }
//     }
//
//     public int add(int val) {
//         this.li.add(val);
//         Collections.sort(li);
//         return li.get(li.size() - this.k);
//     }
// }
//
///**
// * Your KthLargest object will be instantiated and called as such:
// * KthLargest obj = new KthLargest(k, nums);
// * int param_1 = obj.add(val);
// */
