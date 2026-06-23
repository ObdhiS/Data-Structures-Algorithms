package heaps;


public class TaskMaxHeap {
    private Node[] heap;
    private int size;

    public TaskMaxHeap(int s) {
        heap = new Node[s];
        size = 0; 
    }

    public void insert(String name, int p) {
        heap[size] = new Node(name, p);
        size++;
        swim(size - 1);
    }

    public Node extractMax() {
        if (size == 0) return null;
        Node max = heap[0];
        heap[0] = heap[size - 1];
        size--;
        sink(0);
        return max; 
    }

    public void swim(int idx) {
        while (idx > 0) {
            int parent = (idx - 1) / 2;
            if (heap[parent].p >= heap[idx].p) break;
            Node temp = heap[parent]; 
            heap[parent] = heap[idx];
            heap[idx] = temp;
            idx = parent;
        }
    }

    public void sink(int idx) {
        while (true) {
            int left = 2 * idx + 1;
            int right = 2 * idx + 2; 
            int largest = idx;
            if (left < size && heap[left].p > heap[largest].p) largest = left;
            if (right < size && heap[right].p > heap[largest].p) largest = right;
            if (idx == largest) break;
            Node temp = heap[idx];
            heap[idx] = heap[largest];
            heap[largest] = temp;
            idx = largest;
        }
    }
}