class MinHeap {
    private int[] heap;
    private int size;

    public MinHeap(int s) {
        heap = new int[s];
        size = 0; // Starts at 0
    }

    public void insert(int value) {
        heap[size] = value;
        size++;
        swim(size - 1);
    }

    public int extractMin() {
        int min = heap[0];
        heap[0] = heap[size - 1];
        size--;
        sink(0);
        return min;
    }

    private void swim(int idx) {
        while (idx > 0) {
            int parent = (idx - 1) / 2;
            if (heap[parent] <= heap[idx]) break;
            int temp = heap[parent];
            heap[parent] = heap[idx];
            heap[idx] = temp;
            idx = parent;
        }
    }

    private void sink(int idx) {
        while (true) {
            int left = 2 * idx + 1;
            int right = 2 * idx + 2;
            int smallest = idx;
            if (left < size && heap[left] < heap[smallest]) smallest = left;
            if (right < size && heap[right] < heap[smallest]) smallest = right;
            if (smallest == idx) break;
            int temp = heap[idx];
            heap[idx] = heap[smallest];
            heap[smallest] = temp;
            idx = smallest;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        MinHeap mh = new MinHeap(10);
        mh.insert(10);
        mh.insert(5);
        mh.insert(15);
        mh.insert(2);

        System.out.println("Extracted: " + mh.extractMin()); 
        System.out.println("Extracted: " + mh.extractMin()); 
    }
}