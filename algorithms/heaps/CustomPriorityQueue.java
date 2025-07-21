package algorithms.heaps;
import java.util.Arrays;

class MinHeap {
  private int[] heap;
  private int size;
  private int capacity;

  public MinHeap(int capacity) {
    this.capacity = capacity;
    this.size = 0;
    this.heap = new int[capacity];
  }

  private int parent(int i) { return (i - 1) / 2; }
  private int leftChild(int i) { return (2 * i) + 1; }
  private int rightChild(int i) { return (2 * i) + 2; }

  public void insert(int value) {
    if (size == capacity) {
      System.out.println("Heap overflow");
      return;
    }
    heap[size] = value;
    int current = size;
    size++;

    // Heapify Up
    while (current > 0 && heap[current] < heap[parent(current)]) {
      swap(current, parent(current));
      current = parent(current);
    }
  }

  public int extractMin() {
    if (size == 0)
      return Integer.MIN_VALUE;
    if (size == 1) {
      size--;
      return heap[0];
    }

    int root = heap[0];
    heap[0] = heap[size - 1];
    size--;
    heapifyDown(0);

    return root;
  }

  private void heapifyDown(int i) {
    int smallest = i;
    int left = leftChild(i);
    int right = rightChild(i);

    if (left < size && heap[left] < heap[smallest])
      smallest = left;
    if (right < size && heap[right] < heap[smallest])
      smallest = right;

    if (smallest != i) {
      swap(i, smallest);
      heapifyDown(smallest);
    }
  }

  private void swap(int i, int j) {
    int temp = heap[i];
    heap[i] = heap[j];
    heap[j] = temp;
  }

  public void printHeap() {
    System.out.println("Heap: " +
                       Arrays.toString(Arrays.copyOfRange(heap, 0, size)));
  }
}

public class CustomPriorityQueue {
  public static void main(String[] args) {
    MinHeap pq = new MinHeap(10);

    pq.insert(10);
    pq.insert(5);
    pq.insert(20);
    pq.insert(1);

    pq.printHeap();

    System.out.println("Extracted Min: " + pq.extractMin());
    pq.printHeap();
  }
}
